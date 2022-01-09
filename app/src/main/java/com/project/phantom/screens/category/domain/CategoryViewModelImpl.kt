package com.project.phantom.screens.category.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.project.phantom.network.PhantomCEH
import com.project.phantom.screens.base.BaseSnippetCurator
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
        state = state.copy(
            rvDataState = emptyList(),
            lceState = PhantomLceData.getErrorData(it.message),
            isRefreshing = false
        )
    }

    override var state by mutableStateOf(CategoryScreenState())
        private set

    override fun loadPage() {
        launch {
            state = state.copy(lceState = PhantomLceData.getLoadingData())
            delay(LoadDelay)
            val response = fetcher.fetchCategoryPage(initModel = initModel)
            val curatedList = curator.curate(response.snippetSectionList)
            if (curatedList.isNotEmpty()) {
                state = state.copy(
                    lceState = PhantomLceData.getContentData(),
                    rvDataState = curatedList,
                    categoryTitle = response.categoryTitle?.setDefaults(
                        fontStyle = PhantomFontStyle.SEMIBOLD_700,
                        colorName = PhantomColorName.GREY_800
                    ),
                    categorySubtitle = response.categorySubtitle?.setDefaults(
                        fontStyle = PhantomFontStyle.MEDIUM_400,
                        colorName = PhantomColorName.GREY_400
                    )
                )
            } else {
                throw CategoryCurationException()
            }
        }
    }
}
