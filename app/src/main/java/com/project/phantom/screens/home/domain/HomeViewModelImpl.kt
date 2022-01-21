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
import org.koin.core.scope.Scope

class HomeViewModelImpl(
    private val splashAndHomeScope: Scope,
    private val fetcher: HomeFetcher,
    private val repo: HomeRepo,
    private val curator: BaseSnippetCurator
) : HomeViewModel() {

    companion object {
        const val RefreshDelay = 1000L
    }

    override val defaultPhantomCEH = PhantomCEH {
        state = state.copy(
            lceState = getErrorData(it.message),
            rvDataState = emptyList(),
            isRefreshing = false
        )
    }
    override var state by mutableStateOf(HomeScreenState())
        private set

    override fun loadPage() {
        launch {
            // If we have cached response already - great!
            // If we don't have it, we wait for the response to come
            //      - If it comes from the repo - great!
            //      - If it doesn't come (maybe some exception happened),
            //        then we try to fetch it ourselves.
            val cachedResponse = repo.homeResponse
            val response = cachedResponse ?: run {
                // Show a loader since we don't have cached response
                state = state.copy(lceState = getLoadingData())
                repo.waitForResponse() ?: fetcher.fetchHomePage()
            }

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

    override fun onCleared() {
        super.onCleared()
        splashAndHomeScope.close()
    }
}
