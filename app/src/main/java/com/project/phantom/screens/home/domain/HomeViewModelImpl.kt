package com.project.phantom.screens.home.domain

import androidx.lifecycle.MutableLiveData
import com.project.phantom.data.atoms.PhantomLceData
import com.project.phantom.data.atoms.PhantomLceData.Companion.getErrorData
import com.project.phantom.data.snippets.base.SnippetNetworkData
import com.project.phantom.network.PhantomCEH
import com.project.phantom.screens.base.BaseSnippetCurator
import com.project.phantom.screens.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModelImpl(
    private val fetcher: HomeFetcher,
    private val curator: BaseSnippetCurator
) : BaseViewModel(), HomeViewModel {
    override val defaultPhantomCEH = PhantomCEH {
        val lceErrorData = getErrorData(it.message)
        lceData.postValue(lceErrorData)
        rvData.postValue(null)
    }
    override val lceData = MutableLiveData<PhantomLceData>()
    override val rvData = MutableLiveData<SnippetNetworkData>()

    override fun loadPage() {
        launch {
            val response = fetcher.fetchHomePage()
            curator.curate()
        }
    }
}