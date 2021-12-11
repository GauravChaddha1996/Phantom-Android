package com.project.phantom.screens.home.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.project.phantom.network.PhantomCEH
import com.project.phantom.screens.base.BaseSnippetCurator
import com.project.phantom.screens.home.view.HomeScreenState
import com.project.phantom.ui.lce.PhantomLceData.Companion.getContentData
import com.project.phantom.ui.lce.PhantomLceData.Companion.getErrorData
import com.project.phantom.ui.lce.PhantomLceData.Companion.getLoadingData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModelImpl(
    private val fetcher: HomeFetcher,
    private val curator: BaseSnippetCurator
) : HomeViewModel() {

    companion object {
        const val RefreshDelay = 1000L
    }

    override val defaultPhantomCEH = PhantomCEH {
        state = state.copy(lceState = getErrorData(it.message), rvDataState = emptyList())
    }
    override var state by mutableStateOf(HomeScreenState())
        private set

    override fun loadPage() {
        launch {
            state = state.copy(lceState = getLoadingData())
            val response = fetcher.fetchHomePage()
            val curatedList = curator.curate(response.snippetSectionList)
            if (curatedList.isNotEmpty()) {
                state = state.copy(lceState = getContentData(), rvDataState = curatedList)
            } else {
                throw HomeCurationException()
            }
        }
    }

    override fun refreshPage() {
        launch {
            state = state.copy(isRefreshing = true)
            delay(RefreshDelay)
            val response = fetcher.fetchHomePage()
            val curatedList = curator.curate(response.snippetSectionList)
            if (curatedList.isNotEmpty()) {
                state = state.copy(
                    isRefreshing = false,
                    rvDataState = curatedList,
                    lceState = getContentData()
                )
            } else {
                state = state.copy(isRefreshing = false)
                throw HomeCurationException()
            }
        }
    }
}
