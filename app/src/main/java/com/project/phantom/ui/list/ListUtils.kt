package com.project.phantom.ui.list

import androidx.compose.foundation.lazy.LazyListScope
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.category.models.FilterPillData
import com.project.phantom.screens.category.models.FilterPropertySection
import com.project.phantom.ui.grid.GridData
import com.project.phantom.ui.grid.PhantomGrid
import com.project.phantom.ui.snippets.cartItem.CartItemData
import com.project.phantom.ui.snippets.cartItem.CartItemSnippet
import com.project.phantom.ui.snippets.categoryRail.CategoryRailSnippet
import com.project.phantom.ui.snippets.categoryRail.CategoryRailSnippetData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.snippets.filterSheet.FilterPillSnippet
import com.project.phantom.ui.snippets.filterSheet.FilterPropertySnippet
import com.project.phantom.ui.snippets.imagePager.ImagePagerSnippet
import com.project.phantom.ui.snippets.imagePager.ImagePagerSnippetData
import com.project.phantom.ui.snippets.productFull.ProductFullSnippet
import com.project.phantom.ui.snippets.productFull.ProductFullSnippetData
import com.project.phantom.ui.snippets.productRail.ProductRailSnippet
import com.project.phantom.ui.snippets.productRail.ProductRailSnippetData
import com.project.phantom.ui.snippets.sectionHeader.SectionHeaderSnippet
import com.project.phantom.ui.snippets.sectionHeader.SectionHeaderSnippetData
import com.project.phantom.ui.snippets.textSection.TextSnippet
import com.project.phantom.ui.snippets.textSection.TextSnippetData

@Suppress("ComplexMethod", "NestedBlockDepth")
internal fun LazyListScope.handleListSnippetData(
    it: SnippetData,
    interaction: SnippetInteractions
) {
    when (it) {
        is SectionHeaderSnippetData -> {
            item {
                SectionHeaderSnippet(data = it, interaction = interaction)
            }
        }
        is HorizontalListData -> {
            item {
                HorizontalList(rvData = it, interaction = interaction)
            }
        }
        is GridData -> {
            item {
                PhantomGrid(gridData = it, interaction = interaction)
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
        is TextSnippetData -> {
            item {
                TextSnippet(data = it)
            }
        }
        is FilterPropertySection -> {
            item {
                FilterPropertySnippet(propertySection = it, interactions = interaction)
            }
        }
        is FilterPillData -> {
            item {
                FilterPillSnippet(it)
            }
        }
        is ImagePagerSnippetData -> {
            item {
                ImagePagerSnippet(data = it)
            }
        }
        is CartItemData -> {
            item {
                CartItemSnippet(data = it, interaction = interaction)
            }
        }
    }
}
