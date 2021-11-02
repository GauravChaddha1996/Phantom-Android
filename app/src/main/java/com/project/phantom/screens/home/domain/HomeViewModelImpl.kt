package com.project.phantom.screens.home.domain

import androidx.lifecycle.MutableLiveData
import com.project.phantom.data.atoms.PhantomLceData
import com.project.phantom.data.atoms.PhantomLceData.Companion.getContentData
import com.project.phantom.data.atoms.PhantomLceData.Companion.getErrorData
import com.project.phantom.data.atoms.PhantomLceData.Companion.getLoadingData
import com.project.phantom.data.snippets.base.SnippetData
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
        rvData.postValue(emptyList())
    }
    override val lceData = MutableLiveData<PhantomLceData>()
    override val rvData = MutableLiveData<List<SnippetData>>()

    override fun loadPage() {
        launch {
            lceData.postValue(getLoadingData())
            val response = fetcher.fetchHomePage()
            val curatedList = curator.curate(response.snippetSectionList)
            if (curatedList.isNotEmpty()) {
                rvData.postValue(curatedList)
                lceData.postValue(getContentData())
            } else {
                throw Exception("Curated list is empty")
            }
        }
    }
}