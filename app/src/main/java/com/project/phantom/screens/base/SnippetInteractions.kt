package com.project.phantom.screens.base

import com.project.phantom.data.snippets.ProductFullSnippetData
import com.project.phantom.data.snippets.ProductRailSnippetData
import com.project.phantom.ui.snippets.ProductFullSnippetInteraction
import com.project.phantom.ui.snippets.ProductRailSnippetInteraction

open class SnippetInteractions : ProductRailSnippetInteraction, ProductFullSnippetInteraction {

    override fun onProductRailSnippetClicked(data: ProductRailSnippetData?) {
        ClickDataResolver.resolve(data?.phantomClickData)
    }

    override fun onProductFullSnippetClicked(data: ProductFullSnippetData?) {
        ClickDataResolver.resolve(data?.phantomClickData)
    }
}