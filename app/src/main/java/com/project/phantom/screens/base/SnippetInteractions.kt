package com.project.phantom.screens.base

import com.project.phantom.data.snippets.CategoryRailSnippetData
import com.project.phantom.data.snippets.ProductDualSnippetData
import com.project.phantom.data.snippets.ProductFullSnippetData
import com.project.phantom.data.snippets.ProductRailSnippetData
import com.project.phantom.ui.snippets.CategoryRailSnippetInteraction
import com.project.phantom.ui.snippets.ProductDualSnippetInteraction
import com.project.phantom.ui.snippets.ProductFullSnippetInteraction
import com.project.phantom.ui.snippets.ProductRailSnippetInteraction

open class SnippetInteractions :
    ProductRailSnippetInteraction,
    ProductFullSnippetInteraction,
    CategoryRailSnippetInteraction,
    ProductDualSnippetInteraction {

    override fun onProductRailSnippetClicked(data: ProductRailSnippetData?) {
        ClickDataResolver.resolve(data?.phantomClickData)
    }

    override fun onProductFullSnippetClicked(data: ProductFullSnippetData?) {
        ClickDataResolver.resolve(data?.phantomClickData)
    }

    override fun onCategoryRailSnippetClicked(data: CategoryRailSnippetData?) {
        ClickDataResolver.resolve(data?.phantomClickData)
    }

    override fun onProductDualSnippetClicked(data: ProductDualSnippetData?) {
        ClickDataResolver.resolve(data?.phantomClickData)
    }
}