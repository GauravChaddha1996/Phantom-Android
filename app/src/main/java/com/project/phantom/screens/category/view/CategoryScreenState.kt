package com.project.phantom.screens.category.view

import com.project.phantom.ui.lce.PhantomLceData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.TextData

data class CategoryScreenState(
    // Rv states
    val rvDataState: List<SnippetData> = emptyList(),
    val categoryTitle: TextData? = null,
    val categorySubtitle: TextData? = null,

    // Lce states
    val lceState: PhantomLceData = PhantomLceData.getLoadingData(),
    val isRefreshing: Boolean = false
)
