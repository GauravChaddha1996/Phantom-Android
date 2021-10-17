package com.project.phantom.screens.home.domain

import androidx.lifecycle.LiveData
import com.project.phantom.data.uiModels.atoms.PhantomLceData
import com.project.phantom.data.uiModels.snippets.base.BaseSnippetNetworkData

interface HomeViewModel {
    val lceData: LiveData<PhantomLceData>
    val rvData: LiveData<BaseSnippetNetworkData>

    fun loadPage()
}