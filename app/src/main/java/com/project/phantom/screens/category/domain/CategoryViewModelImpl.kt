package com.project.phantom.screens.category.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.project.phantom.network.PhantomCEH
import com.project.phantom.screens.base.BaseSnippetCurator
import com.project.phantom.screens.category.models.FilterPropertySection
import com.project.phantom.screens.category.models.FilterSheetData
import com.project.phantom.screens.category.models.getSelectedFilters
import com.project.phantom.screens.category.models.getSelectedSortMethod
import com.project.phantom.screens.category.view.CategoryPageInitModel
import com.project.phantom.screens.category.view.CategoryScreenState
import com.project.phantom.ui.lce.PhantomLceData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CategoryViewModelImpl(
    private val initModel: CategoryPageInitModel,
    private val fetcher: CategoryFetcher,
    private val curator: BaseSnippetCurator
) : CategoryViewModel() {

    companion object {
        const val LoadDelay = 500L
    }

    override val defaultPhantomCEH = PhantomCEH {
        state = state.copy(lceState = PhantomLceData.getErrorData(it.message))
    }

    override var state by mutableStateOf(CategoryScreenState())
        private set

    override fun loadPage() = loadPageImpl()

    override fun onApplyClicked() {
        val oldSortMethodData = state.selectedSortMethod
        val newSortMethodData = state.sortSheetData.getSelectedSortMethod()

        val oldFilters = state.selectedFilters
        val newFilters = state.filterSheetData.getSelectedFilters()

        val isSortMethodDifferent = oldSortMethodData != newSortMethodData
        val areFiltersDifferent = oldFilters != newFilters

        if (isSortMethodDifferent || areFiltersDifferent) {
            loadPageImpl()
        }
    }

    override fun onFilterClearClicked() {
        val oldFilterSheetData = state.filterSheetData
        val newFilterSheetData = FilterSheetData(
            oldFilterSheetData?.propertySections?.map {
                FilterPropertySection(
                    it.name,
                    it.pills?.map { pillData ->
                        pillData.selected = false
                        pillData
                    }
                )
            }
        )
        state = state.copy(filterSheetData = newFilterSheetData)
    }

    private fun loadPageImpl() {
        launch {
            state = state.copy(
                lceState = PhantomLceData.getLoadingData(),
                rvDataState = emptyList(),
                frontLayerHeader = null
            )
            delay(LoadDelay)
            val response = fetcher.fetchCategoryPage(
                initModel = initModel,
                selectedSortMethodData = state.sortSheetData.getSelectedSortMethod(),
                selectedFilters = state.filterSheetData.getSelectedFilters()
            )
            val curatedList = curator.curate(response.snippetSectionList)
            val isCuratedListNotEmpty = curatedList.isNotEmpty()
            state = state.copy(
                lceState = if (isCuratedListNotEmpty) {
                    PhantomLceData.getContentData()
                } else {
                    PhantomLceData.getEmptyResultData(null)
                },
                pageTitle = response.pageTitle,
                frontLayerHeader = response.snippetSectionHeader.takeIf { isCuratedListNotEmpty },
                rvDataState = curatedList,
                sortSheetData = response.sortSheetData?.apply { setDefaults() },
                selectedSortMethod = response.sortSheetData.getSelectedSortMethod(),
                filterSheetData = response.filterSheetData?.apply { setDefaults() },
                selectedFilters = response.filterSheetData.getSelectedFilters()
            )
        }
    }
}
