package com.project.phantom.screens.base

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.phantom.screens.product.ui.ProductBottomSheet
import com.project.phantom.screens.product.ui.ProductPageInitModel
import com.project.phantom.theme.CornerStyle
import com.project.phantom.theme3.AppTheme
import com.project.phantom.theme3.AppThemeColors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

abstract class BaseActivity : AppCompatActivity(), KoinComponent {

    lateinit var bottomSheetHelper: BottomSheetHelper

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var currentBottomSheetType by remember { mutableStateOf(BottomSheetType.INVALID) }
            var currentBottomSheetData: Any? by remember { mutableStateOf(null) }
            AppTheme {
                val scope = rememberCoroutineScope()
                val scaffoldState = rememberBottomSheetScaffoldState(
                    bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
                )
                bottomSheetHelper = makeBottomSheetHelper(
                    scope = scope,
                    scaffoldState = scaffoldState,
                    updateCurrentStates = { bottomSheetType: BottomSheetType, bottomSheetData: Any? ->
                        currentBottomSheetType = bottomSheetType
                        currentBottomSheetData = bottomSheetData
                    },
                    getCurrentBottomSheetType = {
                        currentBottomSheetType
                    }
                )
                BottomSheetScaffold(
                    sheetPeekHeight = 0.dp,
                    sheetShape = CornerStyle.large,
                    sheetContent = {
                        // If sheet is collapsed anytime, reset the data to invalid sheet
                        // so that the last shown sheet isn't shown again
                        if (scaffoldState.bottomSheetState.isCollapsed) {
                            bottomSheetHelper.resetCurrentBottomSheet()
                        }
                        when (currentBottomSheetType) {
                            BottomSheetType.PRODUCT -> ProductBottomSheet(
                                initModel = currentBottomSheetData as ProductPageInitModel
                            )
                            BottomSheetType.INVALID -> {}
                        }
                    },
                    scaffoldState = scaffoldState,
                    content = {
                        Box {
                            // Actual content
                            Content()
                            ScrimForBottomSheet(scope, scaffoldState, currentBottomSheetType)
                        }
                    }
                )
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    private fun makeBottomSheetHelper(
        scope: CoroutineScope,
        scaffoldState: BottomSheetScaffoldState,
        updateCurrentStates: (BottomSheetType, Any?) -> Unit,
        getCurrentBottomSheetType: () -> BottomSheetType
    ): BottomSheetHelper {
        return object : BottomSheetHelper {

            val bottomSheetState = scaffoldState.bottomSheetState
            override fun openBottomSheet(bottomSheetType: BottomSheetType, bottomSheetData: Any?) {
                scope.launch {
                    bottomSheetState.expand()
                    updateCurrentStates.invoke(bottomSheetType, bottomSheetData)
                }
            }

            override fun closeCurrentBottomSheet(): Boolean {
                if (bottomSheetState.isExpanded && getCurrentBottomSheetType.invoke() != BottomSheetType.INVALID) {
                    scope.launch {
                        bottomSheetState.collapse()
                        updateCurrentStates.invoke(BottomSheetType.INVALID, null)
                    }
                    return true
                }
                return false
            }
        }
    }

    @ExperimentalMaterialApi
    @Composable
    private fun ScrimForBottomSheet(
        scope: CoroutineScope,
        scaffoldState: BottomSheetScaffoldState,
        currentBottomSheetType: BottomSheetType
    ) {
        AnimatedVisibility(
            visible = scaffoldState.bottomSheetState.isExpanded &&
                currentBottomSheetType != BottomSheetType.INVALID,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppThemeColors.onBackground)
                    .clickable { scope.launch { bottomSheetHelper.closeCurrentBottomSheet() } }
            )
        }
    }

    override fun onBackPressed() {
        if (!bottomSheetHelper.closeCurrentBottomSheet()) {
            super.onBackPressed()
        }
    }

    @Composable
    abstract fun Content()
}

interface BottomSheetHelper {
    fun openBottomSheet(bottomSheetType: BottomSheetType, bottomSheetData: Any?)
    fun closeCurrentBottomSheet(): Boolean
    fun resetCurrentBottomSheet() {
        closeCurrentBottomSheet()
    }
}
