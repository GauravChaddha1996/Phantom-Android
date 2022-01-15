package com.project.phantom.screens.category.view

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.category.domain.CategoryViewModel
import com.project.phantom.screens.category.models.SortMethodData
import com.project.phantom.screens.category.view.CategoryScreenState.BackLayerData
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomColors
import com.project.phantom.ui.button.ButtonData
import com.project.phantom.ui.button.PhantomButton
import com.project.phantom.ui.lce.PhantomLCE
import com.project.phantom.ui.lce.PhantomLceInteraction
import com.project.phantom.ui.list.VerticalList
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class CategoryScreen {

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun Get(
        activity: CategoryActivity,
        viewModel: CategoryViewModel
    ) {
        val scope = rememberCoroutineScope()
        val state = viewModel.state
        val scaffoldState = rememberBackdropScaffoldState(initialValue = BackdropValue.Concealed)
        var backLayerData by remember { mutableStateOf(BackLayerData()) }
        val interactions = remember {
            object : SnippetInteractions(activity = activity) {
                override fun onSortMethodClicked(sortMethodData: SortMethodData) {
                    super.onSortMethodClicked(sortMethodData)
                    viewModel.onSortMethodSelected(sortMethodData = sortMethodData)
                    scope.launch { scaffoldState.conceal() }
                }
            }
        }
        val topAppBar = remember { CategoryPageTopAppBar() }
        BackdropScaffold(
            scaffoldState = scaffoldState,
            appBar = {
                topAppBar.Get(
                    state = state,
                    scaffoldState = scaffoldState,
                    backLayerData = backLayerData,
                    backClickable = { activity.onBackPressed() },
                    closeClickable = { scope.launch { scaffoldState.conceal() } },
                    filterClickable = {
                        scope.launch {
                            backLayerData = BackLayerData(showFilterInBackLayer = true)
                            scaffoldState.reveal()
                        }
                    }
                ) {
                    scope.launch {
                        backLayerData = BackLayerData(showSortInBackLayer = true)
                        scaffoldState.reveal()
                    }
                }
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
                        contentPadding = PaddingValues(bottom = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    )
                }
                backLayerData.showFilterInBackLayer -> {
                    Column {
                        VerticalList(
                            rvDataState = state.filterSheetData?.let { listOf(it) },
                            interaction = interactions,
                            contentPadding = PaddingValues(bottom = 8.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
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
                    modifier = Modifier.padding(12.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.5.dp)
                        .background(PhantomColors.resolve(PhantomColorName.GREY_200))
                )
            }
            VerticalList(
                rvDataState = state.rvDataState,
                interaction = interactions,
                contentPadding = PaddingValues(vertical = 12.dp)
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
