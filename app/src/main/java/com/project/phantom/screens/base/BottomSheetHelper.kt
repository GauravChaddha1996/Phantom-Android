package com.project.phantom.screens.base

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.project.phantom.screens.base.BottomSheetType.INVALID
import com.project.phantom.screens.product.ui.ProductBottomSheet
import com.project.phantom.screens.product.ui.ProductPageInitModel
import com.project.phantom.theme.color.PhantomColor
import com.project.phantom.theme.color.resolve
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

enum class BottomSheetType {
    PRODUCT, INVALID
}

interface BottomSheetHelper {
    fun openBottomSheet(bottomSheetType: BottomSheetType, bottomSheetData: Any?)
    fun canHandleBackPress(): Boolean
}

@OptIn(ExperimentalMaterialApi::class)
class BottomSheetHelperImpl(
    private val scope: CoroutineScope,
    private val scaffoldState: BottomSheetScaffoldState,
    private val getCurrentBottomSheetDataHolder: () -> BottomSheetDataHolder,
    private val updateCurrentBottomSheetDataHolder: (BottomSheetDataHolder) -> Unit
) : BottomSheetHelper {
    class BottomSheetDataHolder(val type: BottomSheetType, val data: Any?)

    private val bottomSheetState = scaffoldState.bottomSheetState

    override fun openBottomSheet(bottomSheetType: BottomSheetType, bottomSheetData: Any?) {
        scope.launch {
            bottomSheetState.expand()
            updateCurrentBottomSheetDataHolder.invoke(
                BottomSheetDataHolder(bottomSheetType, bottomSheetData)
            )
        }
    }

    override fun canHandleBackPress(): Boolean {
        return closeCurrentBottomSheet()
    }

    private fun closeCurrentBottomSheet(): Boolean {
        val currentBottomSheetDataHolder = getCurrentBottomSheetDataHolder.invoke()
        if (bottomSheetState.isExpanded && currentBottomSheetDataHolder.type != INVALID) {
            scope.launch {
                bottomSheetState.collapse()
                resetCurrentBottomSheet()
            }
            return true
        }
        return false
    }

    @Composable
    fun BottomSheetContent() {
        val systemUiController = rememberSystemUiController()
        val currentBottomSheetDataHolder = getCurrentBottomSheetDataHolder.invoke()

        // If sheet is collapsed anytime, reset the data to invalid sheet
        // so that the last shown sheet isn't shown again
        if (scaffoldState.bottomSheetState.isCollapsed) {
            resetCurrentBottomSheet()
        }
        if (currentBottomSheetDataHolder.type != INVALID) {
            SideEffect {
                systemUiController.setStatusBarColor(PhantomColor.Scrim.resolve())
            }
        }
        when (currentBottomSheetDataHolder.type) {
            BottomSheetType.PRODUCT -> {
                ProductBottomSheet(initModel = currentBottomSheetDataHolder.data as ProductPageInitModel)
            }
            INVALID -> {
            }
        }
    }

    @ExperimentalMaterialApi
    @Composable
    fun ScrimForBottomSheet(
        scope: CoroutineScope,
        scaffoldState: BottomSheetScaffoldState,
        currentBottomSheetDataHolder: BottomSheetDataHolder
    ) {
        AnimatedVisibility(
            visible = scaffoldState.bottomSheetState.isExpanded &&
                currentBottomSheetDataHolder.type != INVALID,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(PhantomColor.Scrim.resolve())
                    .clickable(
                        onClick = { scope.launch { closeCurrentBottomSheet() } },
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    )
            )
        }
    }

    private fun resetCurrentBottomSheet() {
        updateCurrentBottomSheetDataHolder.invoke(BottomSheetDataHolder(INVALID, null))
    }
}
