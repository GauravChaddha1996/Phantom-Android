package com.project.phantom.screens.category.view

import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.BackdropValue
import androidx.compose.material.ContentAlpha
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.project.phantom.LaunchOnce
import com.project.phantom.R
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.cart.view.CartFab
import com.project.phantom.screens.category.domain.CategoryViewModel
import com.project.phantom.screens.category.view.CategoryScreenState.BackLayerData
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.color.AppThemeColors
import com.project.phantom.ui.button.ButtonData
import com.project.phantom.ui.button.PhantomButton
import com.project.phantom.ui.lce.PhantomLCE
import com.project.phantom.ui.lce.PhantomLceInteraction
import com.project.phantom.ui.list.VerticalList
import com.project.phantom.ui.snippets.filterSheet.FilterSheet
import com.project.phantom.ui.snippets.sortSheet.SortSheet
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CategoryActivity : BaseActivity() {

    companion object {
        private const val INIT_MODEL = "init_model"

        fun start(activity: BaseActivity, initModel: CategoryPageInitModel) {
            val intent = Intent(activity, CategoryActivity::class.java)
            intent.putExtra(INIT_MODEL, initModel)
            activity.startActivity(intent)
        }
    }

    private lateinit var initModel: CategoryPageInitModel
    private val viewModel: CategoryViewModel by viewModel(parameters = {
        parametersOf(initModel)
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initModel = intent.getSerializableExtra(INIT_MODEL) as CategoryPageInitModel
    }

    @ExperimentalMaterialApi
    @Composable
    override fun Content() {
        val state = viewModel.state
        val systemUiController = rememberSystemUiController()
        val scope = rememberCoroutineScope()
        val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed)
        var backLayerData by remember { mutableStateOf(BackLayerData()) }
        val interactions = remember { SnippetInteractions(this) }
        val topAppBar = remember { CategoryPageTopAppBar() }

        SideEffect { systemUiController.setStatusBarColor(AppThemeColors.primaryContainer) }
        LaunchOnce { viewModel.loadPage() }

        BackdropScaffold(
            scaffoldState = scaffoldState,
            appBar = {
                topAppBar.Get(
                    state = state,
                    backLayerData = backLayerData,
                    backClickable = { onBackPressed() },
                    closeClickable = {
                        backLayerData = BackLayerData()
                        scope.launch { scaffoldState.conceal() }
                    },
                    filterClickable = {
                        scope.launch {
                            backLayerData = BackLayerData(showFilterInBackLayer = true)
                            scaffoldState.reveal()
                        }
                    },
                    sortClickable = {
                        scope.launch {
                            backLayerData = BackLayerData(showSortInBackLayer = true)
                            scaffoldState.reveal()
                        }
                    },
                    filterClearClickable = {
                        viewModel.onFilterClearClicked()
                    }
                )
            },
            backLayerContent = {
                GetBackLayer(
                    state = state,
                    scaffoldState = scaffoldState,
                    interactions = interactions,
                    backLayerData = backLayerData,
                    viewModel = viewModel,
                    scope = scope
                ) { backLayerData = BackLayerData() }
            },
            frontLayerContent = {
                GetFrontLayer(
                    state = state,
                    interactions = interactions,
                    viewModel = viewModel
                )
            },
            gesturesEnabled = false,
            backLayerBackgroundColor = AppThemeColors.primaryContainer,
            backLayerContentColor = AppThemeColors.onPrimaryContainer,
            frontLayerBackgroundColor = AppThemeColors.background,
            frontLayerContentColor = AppThemeColors.onBackground,
            frontLayerScrimColor = AppThemeColors.onPrimary.copy(alpha = 0.6f)
        )
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .padding(PaddingStyle.large)
                    .align(Alignment.BottomEnd)
            ) {
                CartFab(
                    activity = this@CategoryActivity,
                    externalVisibilityCheck = { state.lceState.isSuccessOrNoResultState() },
                    disable = backLayerData.isActive()
                )
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    private fun GetBackLayer(
        state: CategoryScreenState,
        scaffoldState: BackdropScaffoldState,
        interactions: SnippetInteractions,
        backLayerData: BackLayerData,
        viewModel: CategoryViewModel,
        scope: CoroutineScope,
        clearBackLayerData: () -> Unit
    ) {
        if (backLayerData.isActive()) {
            Column {
                when {
                    backLayerData.showSortInBackLayer -> {
                        SortSheet(state.sortSheetData)
                    }
                    backLayerData.showFilterInBackLayer -> {
                        FilterSheet(state.filterSheetData, interactions)
                    }
                }
                PhantomButton(
                    data = ButtonData(TextData(stringResource(R.string.apply))),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = PaddingStyle.large,
                            end = PaddingStyle.large,
                            bottom = PaddingStyle.large,
                            top = PaddingStyle.zero
                        ),
                    colors = ButtonDefaults.filledTonalButtonColors(
                        containerColor = AppThemeColors.primary,
                        contentColor = AppThemeColors.onPrimary
                    ),
                    onClick = {
                        clearBackLayerData.invoke()
                        viewModel.onApplyClicked()
                        scope.launch { scaffoldState.conceal() }
                    }
                )
            }
        }
    }

    @Composable
    private fun GetFrontLayer(
        state: CategoryScreenState,
        interactions: SnippetInteractions,
        viewModel: CategoryViewModel
    ) {
        Column {
            if (state.frontLayerHeader != null) {
                PhantomText(
                    data = state.frontLayerHeader,
                    modifier = Modifier
                        .padding(PaddingStyle.large)
                        .alpha(ContentAlpha.medium)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.5.dp)
                        .background(AppThemeColors.onBackground.copy(alpha = 0.05f))

                )
            }
            VerticalList(
                rvDataState = state.rvDataState,
                interaction = interactions,
                contentPadding = PaddingValues(vertical = PaddingStyle.extra)
            )
        }
        PhantomLCE(
            data = state.lceState,
            interaction = object : PhantomLceInteraction {
                override fun onRetryClicked() {
                    viewModel.loadPage()
                }
            }
        )
    }
}
