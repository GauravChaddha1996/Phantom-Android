package com.project.phantom.ui.list

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.mutableStateOf
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.ui.grid.GridData
import com.project.phantom.ui.grid.PhantomGrid
import com.project.phantom.ui.snippets.categoryRail.CategoryRailSnippet
import com.project.phantom.ui.snippets.categoryRail.CategoryRailSnippetData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.snippets.productFull.ProductFullSnippet
import com.project.phantom.ui.snippets.productFull.ProductFullSnippetData
import com.project.phantom.ui.snippets.productRail.ProductRailSnippet
import com.project.phantom.ui.snippets.productRail.ProductRailSnippetData
import com.project.phantom.ui.snippets.sectionHeader.SectionHeaderSnippet
import com.project.phantom.ui.snippets.sectionHeader.SectionHeaderSnippetData

internal fun LazyListScope.handleListSnippetData(it: SnippetData, interaction: SnippetInteractions) {
    when (it) {
        is SectionHeaderSnippetData -> {
            item {
                SectionHeaderSnippet(data = it, interaction = interaction)
            }
        }
        is HorizontalListData -> {
            item {
                HorizontalList(rvDataState = mutableStateOf(it), interaction = interaction)
            }
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
