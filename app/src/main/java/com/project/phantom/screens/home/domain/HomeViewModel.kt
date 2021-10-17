package com.project.phantom.screens.home.domain

import androidx.lifecycle.LiveData
import com.project.phantom.data.atoms.PhantomLceData
import com.project.phantom.data.snippets.base.SnippetNetworkData

interface HomeViewModel {
    val lceData: LiveData<PhantomLceData>
    val rvData: LiveData<SnippetNetworkData>

    fun loadPage()
}