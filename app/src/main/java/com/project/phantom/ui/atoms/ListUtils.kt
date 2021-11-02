package com.project.phantom.ui.atoms

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.mutableStateOf
import com.project.phantom.data.snippets.ProductFullSnippetData
import com.project.phantom.data.snippets.base.HorizontalListData
import com.project.phantom.data.snippets.base.SnippetData
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.ui.snippets.ProductFullSnippet


internal fun LazyListScope.handleSnippetData(it: SnippetData) {
    when (it) {
        is HorizontalListData -> {
            item { HorizontalList(rvDataState = mutableStateOf(it)) }
        }
        is ProductFullSnippetData -> {
            item {
                ProductFullSnippet(data = it, interaction = SnippetInteractions())
            }
        }
    }
}