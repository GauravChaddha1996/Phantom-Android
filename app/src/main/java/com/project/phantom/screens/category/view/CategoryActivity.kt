package com.project.phantom.screens.category.view

import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.phantom.LaunchOnce
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.category.domain.CategoryViewModel
import com.project.phantom.screens.category.models.SortMethodData
import com.project.phantom.screens.category.view.CategoryScreenState.BackLayerData
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.resolve
import com.project.phantom.ui.button.ButtonData
import com.project.phantom.ui.button.PhantomButton
import com.project.phantom.ui.lce.PhantomLCE
import com.project.phantom.ui.lce.PhantomLceInteraction
import com.project.phantom.ui.list.VerticalList
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
        LaunchOnce { viewModel.loadPage() }
        val categoryScreenColors = remember { CategoryScreenColors.get(initModel) }
        CompositionLocalProvider(
            values = arrayOf(LocalCategoryScreenColors provides categoryScreenColors),
            content = {
                val scope = rememberCoroutineScope()
                val state = viewModel.state
                val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed)
                var backLayerData by remember { mutableStateOf(BackLayerData()) }
                val interactions = remember { getSnippetInteractions(scope, scaffoldState) }
                val topAppBar = remember { CategoryPageTopAppBar() }
                BackdropScaffold(
                    scaffoldState = scaffoldState,
                    appBar = {
                        topAppBar.Get(
                            state = state,
                            scaffoldState = scaffoldState,
                            backLayerData = backLayerData,
                            backClickable = { onBackPressed() },
                            closeClickable = { scope.launch { scaffoldState.conceal() } },
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
                        )
                    },
                    frontLayerContent = {
                        GetFrontLayer(
                            state = state,
                            interactions = interactions,
                            viewModel = viewModel
                        )
                    },
                    gesturesEnabled = false,
                    peekHeight = 56.dp,
                    headerHeight = 56.dp,
                    backLayerBackgroundColor = LocalCategoryScreenColors.current.backLayerBackground
                )
            }
        )
    }

    @ExperimentalMaterialApi
    private fun getSnippetInteractions(
        scope: CoroutineScope,
        scaffoldState: BackdropScaffoldState
    ) = object : SnippetInteractions(activity = this) {
        override fun onSortMethodClicked(sortMethodData: SortMethodData) {
            super.onSortMethodClicked(sortMethodData)
            viewModel.onSortMethodSelected(sortMethodData = sortMethodData)
            scope.launch { scaffoldState.conceal() }
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
        scope: CoroutineScope
    ) {
        if (scaffoldState.isRevealed) {
            when {
                backLayerData.showSortInBackLayer -> {
                    VerticalList(
                        rvDataState = state.sortSheetData?.methods,
                        interaction = interactions,
                        contentPadding = PaddingValues(bottom = PaddingStyle.medium),
                        verticalArrangement = Arrangement.spacedBy(PaddingStyle.small)
                    )
                }
                backLayerData.showFilterInBackLayer -> {
                    Column {
                        VerticalList(
                            rvDataState = state.filterSheetData?.let { listOf(it) },
                            interaction = interactions,
                            contentPadding = PaddingValues(bottom = PaddingStyle.medium),
                            verticalArrangement = Arrangement.spacedBy(PaddingStyle.small)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(PaddingStyle.large)
                        ) {
                            PhantomButton(
                                data = ButtonData(TextData("Apply")),
                                modifier = Modifier.fillMaxWidth(),
                                onClick = {
                                    viewModel.onFilterApplied()
                                    scope.launch { scaffoldState.conceal() }
                                }
                            )
                        }
                    }
                }
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
                    modifier = Modifier.padding(PaddingStyle.large)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.5.dp)
                        .background(com.project.phantom.theme.PhantomColorName.GREY_200.resolve())
                )
            }
            VerticalList(
                rvDataState = state.rvDataState,
                interaction = interactions,
                contentPadding = PaddingValues(vertical = PaddingStyle.large)
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
