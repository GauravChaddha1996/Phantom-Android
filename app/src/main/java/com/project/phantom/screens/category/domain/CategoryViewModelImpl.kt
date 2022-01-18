package com.project.phantom.screens.category.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.project.phantom.network.PhantomCEH
import com.project.phantom.screens.base.BaseSnippetCurator
import com.project.phantom.screens.category.models.SortMethodData
import com.project.phantom.screens.category.models.getSelectedPropertyValueIds
import com.project.phantom.screens.category.models.getSelectedSortMethodData
import com.project.phantom.screens.category.view.CategoryPageInitModel
import com.project.phantom.screens.category.view.CategoryScreenState
import com.project.phantom.theme.PhantomColorName.OnBackground
import com.project.phantom.theme.PhantomColorName.OnPrimary
import com.project.phantom.theme.PhantomColorName.Primary
import com.project.phantom.theme.PhantomFontStyle.TitleLarge
import com.project.phantom.theme.PhantomFontStyle.TitleMedium
import com.project.phantom.ui.commons.getResolvedColor
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

    override var state by mutableStateOf(
        CategoryScreenState(
            lceState = getPhantomLceLoadingData()
        )
    )
        private set

    private fun getPhantomLceLoadingData() = PhantomLceData.getLoadingData()
        .copy(phantomGhostColor = initModel.categoryColor.getResolvedColor(Primary))

    override fun loadPage() {
        loadPageImpl(null)
    }

    override fun onSortMethodSelected(sortMethodData: SortMethodData) {
        val oldSortMethodData = state.selectedSortMethodData
        val isSortMethodDifferent = oldSortMethodData?.id != sortMethodData.id
        if (isSortMethodDifferent) {
            loadPageImpl(sortMethodData)
        }
    }

    override fun onFilterApplied() {
        val oldSelectedPropertyValueIds = state.selectedPropertyValueIds
        val newSelectedPropertyValueIds = state.filterSheetData.getSelectedPropertyValueIds()
        val areSelectedPropertyValueIdsDifferent =
            oldSelectedPropertyValueIds != newSelectedPropertyValueIds
        if (areSelectedPropertyValueIdsDifferent) {
            loadPageImpl(state.selectedSortMethodData)
        }
    }

    private fun loadPageImpl(newSortMethodData: SortMethodData?) {
        launch {
            state = state.copy(
                lceState = getPhantomLceLoadingData(),
                rvDataState = emptyList(),
                selectedSortMethodData = newSortMethodData,
                frontLayerHeader = null
            )
            delay(LoadDelay)
            val response = fetcher.fetchCategoryPage(
                initModel = initModel,
                selectedSortMethodData = newSortMethodData,
                selectedPropertyValueSet = state.filterSheetData.getSelectedPropertyValueIds()
            )
            val curatedList = curator.curate(response.snippetSectionList)
            if (curatedList.isNotEmpty()) {
                state = state.copy(
                    lceState = PhantomLceData.getContentData()
                        .copy(phantomGhostColor = initModel.categoryColor.getResolvedColor(Primary)),
                    pageTitle = response.pageTitle?.setDefaults(
                        fontStyle = TitleLarge,
                        colorName = OnPrimary
                    ),
                    frontLayerHeader = response.snippetSectionHeader?.setDefaults(
                        fontStyle = TitleMedium,
                        colorName = OnBackground
                    ),
                    rvDataState = curatedList,
                    sortSheetData = response.sortSheetData?.also { it.setDefaults() },
                    selectedSortMethodData = response.sortSheetData.getSelectedSortMethodData(),
                    filterSheetData = response.filterSheetData?.also { it.setDefaults() },
                    selectedPropertyValueIds = response.filterSheetData.getSelectedPropertyValueIds()
                )
            } else {
                state = CategoryScreenState(
                    lceState = PhantomLceData.getEmptyResultData(null),
                    pageTitle = response.pageTitle?.setDefaults(
                        fontStyle = TitleLarge,
                        colorName = OnPrimary
                    ),
                    sortSheetData = response.sortSheetData?.also { it.setDefaults() },
                    selectedSortMethodData = response.sortSheetData.getSelectedSortMethodData(),
                    filterSheetData = response.filterSheetData?.also { it.setDefaults() },
                    selectedPropertyValueIds = response.filterSheetData.getSelectedPropertyValueIds()
                )
            }
        }
    }
}
