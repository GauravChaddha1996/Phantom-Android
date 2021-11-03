package com.project.phantom.ui.atoms

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.mutableStateOf
import com.project.phantom.data.snippets.CategoryRailSnippetData
import com.project.phantom.data.snippets.ProductFullSnippetData
import com.project.phantom.data.snippets.ProductRailSnippetData
import com.project.phantom.data.snippets.base.GridData
import com.project.phantom.data.snippets.base.HorizontalListData
import com.project.phantom.data.snippets.base.SectionHeaderSnippetData
import com.project.phantom.data.snippets.base.SnippetData
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.ui.snippets.CategoryRailSnippet
import com.project.phantom.ui.snippets.ProductFullSnippet
import com.project.phantom.ui.snippets.ProductRailSnippet
import com.project.phantom.ui.snippets.SectionHeaderSnippet


internal fun LazyListScope.handleListSnippetData(it: SnippetData, interaction: SnippetInteractions) {
    when (it) {
        is SectionHeaderSnippetData -> {
            item {
                SectionHeaderSnippet(data = it, interaction = interaction)
            }
        }
        is HorizontalListData -> {
            item { HorizontalList(rvDataState = mutableStateOf(it), interaction = interaction) }
        }
        is GridData -> {
            item {
                PhantomGrid(gridDataState = mutableStateOf(it), interaction = interaction)
            }
        }
        is ProductFullSnippetData -> {
            item {
                ProductFullSnippet(data = it, interaction = interaction)
            }
        }
        is ProductRailSnippetData -> {
            item {
                ProductRailSnippet(data = it, interaction = interaction)
            }
        }
        is CategoryRailSnippetData -> {
            item {
                CategoryRailSnippet(data = it, interaction = interaction)
            }
        }
    }
}