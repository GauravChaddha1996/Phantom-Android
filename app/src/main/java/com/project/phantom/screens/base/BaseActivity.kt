package com.project.phantom.screens.base

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue.Collapsed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.project.phantom.screens.base.BottomSheetHelperImpl.BottomSheetDataHolder
import com.project.phantom.screens.base.BottomSheetType.INVALID
import com.project.phantom.theme.AppTheme
import com.project.phantom.theme.CornerStyle
import com.project.phantom.theme.color.AppThemeColors
import org.koin.core.component.KoinComponent

abstract class BaseActivity : AppCompatActivity(), KoinComponent {

    lateinit var bottomSheetHelper: BottomSheetHelperImpl

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var currentBottomSheetDataHolder by remember {
                mutableStateOf(BottomSheetDataHolder(INVALID, null))
            }
            AppTheme {
                val scope = rememberCoroutineScope()
                val scaffoldState = rememberBottomSheetScaffoldState(
                    bottomSheetState = rememberBottomSheetState(initialValue = Collapsed)
                )
                bottomSheetHelper = BottomSheetHelperImpl(
                    scope = scope,
                    scaffoldState = scaffoldState,
                    getCurrentBottomSheetDataHolder = { currentBottomSheetDataHolder },
                    updateCurrentBottomSheetDataHolder = { bottomSheetDataHolder ->
                        currentBottomSheetDataHolder = bottomSheetDataHolder
                    }
                )
                BottomSheetScaffold(
                    sheetPeekHeight = 0.dp,
                    sheetShape = CornerStyle.large,
                    sheetBackgroundColor = AppThemeColors.surface,
                    sheetContentColor = AppThemeColors.onSurface,
                    contentColor = AppThemeColors.onBackground,
                    backgroundColor = AppThemeColors.background,
                    sheetContent = { bottomSheetHelper.BottomSheetContent() },
                    scaffoldState = scaffoldState,
                    content = {
                        Box {
                            // Actual content
                            Content()
                            bottomSheetHelper.ScrimForBottomSheet(
                                scope = scope,
                                scaffoldState = scaffoldState,
                                currentBottomSheetDataHolder = currentBottomSheetDataHolder
                            )
                        }
                    }
                )
            }
        }
    }

    override fun onBackPressed() {
        if (!bottomSheetHelper.canHandleBackPress()) {
            super.onBackPressed()
        }
    }

    @Composable
    abstract fun Content()
}
