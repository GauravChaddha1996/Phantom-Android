package com.project.phantom.screens.category.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.project.phantom.network.PhantomCEH
import com.project.phantom.screens.base.BaseSnippetCurator
import com.project.phantom.screens.category.models.SortMethodData
import com.project.phantom.screens.category.view.CategoryPageInitModel
import com.project.phantom.screens.category.view.CategoryScreenState
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.ui.lce.PhantomLceData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CategoryViewModelImpl(
    private val initModel: CategoryPageInitModel,
    private val fetcher: CategoryFetcher,
    private val curator: BaseSnippetCurator
) : CategoryViewModel() {

    companion object {
        const val LoadDelay = 2000L
    }

    override val defaultPhantomCEH = PhantomCEH {
        state = state.copy(lceState = PhantomLceData.getErrorData(it.message))
    }

    override var state by mutableStateOf(CategoryScreenState())
        private set

    override fun loadPage() {
        loadPageImpl(null)
    }

    override fun onSortMethodClicked(sortMethodData: SortMethodData) {
        loadPageImpl(sortMethodData)
    }

    private fun loadPageImpl(sortMethodData: SortMethodData?) {
        if (sortMethodData != null && state.sortMethodData?.id == sortMethodData.id) return
        launch {
            state = state.copy(
                lceState = PhantomLceData.getLoadingData(),
                rvDataState = emptyList(),
                sortMethodData = sortMethodData,
                frontLayerHeader = null
            )
            delay(LoadDelay)
            val response = fetcher.fetchCategoryPage(
                initModel = initModel,
                sortMethodData = sortMethodData
            )
            val curatedList = curator.curate(response.snippetSectionList)
            if (curatedList.isNotEmpty()) {
                state = state.copy(
                    lceState = PhantomLceData.getContentData(),
                    pageTitle = response.pageTitle?.setDefaults(
                        fontStyle = PhantomFontStyle.SEMIBOLD_700,
                        colorName = PhantomColorName.GREY_900
                    ),
                    frontLayerHeader = response.snippetSectionHeader?.setDefaults(
                        fontStyle = PhantomFontStyle.MEDIUM_600,
                        colorName = PhantomColorName.GREY_700
                    ),
                    rvDataState = curatedList,
                    sortSheetData = response.sortSheetData?.also { it.setDefaults() },
                    sortMethodData = response.sortSheetData?.methods?.firstOrNull { it.selected == true }
                )
            } else {
                throw CategoryCurationException()
            }
        }
    }
}
