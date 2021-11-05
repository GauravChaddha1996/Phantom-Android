package com.project.phantom.screens.home.domain

import androidx.lifecycle.LiveData
import com.project.phantom.ui.lce.PhantomLceData
import com.project.phantom.ui.snippets.commons.SnippetData

interface HomeViewModel {
    val lceData: LiveData<PhantomLceData>
    val rvData: LiveData<List<SnippetData>>

    fun loadPage()
}