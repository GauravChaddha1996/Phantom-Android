package com.project.phantom.screens.category.view

import com.project.phantom.ui.lce.PhantomLceData
import com.project.phantom.ui.snippets.commons.SnippetData

data class CategoryScreenState(
    // Rv states
    val rvDataState: List<SnippetData> = emptyList(),

    // Lce states
    val lceState: PhantomLceData = PhantomLceData.getLoadingData(),
    val isRefreshing: Boolean = false
)
