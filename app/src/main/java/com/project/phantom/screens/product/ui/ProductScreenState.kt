package com.project.phantom.screens.product.ui

import com.project.phantom.ui.lce.PhantomLceData
import com.project.phantom.ui.snippets.commons.SnippetData

data class ProductScreenState(
    val lceState: PhantomLceData = PhantomLceData.getLoadingData(),
    val rvDataState: List<SnippetData> = emptyList()
)
