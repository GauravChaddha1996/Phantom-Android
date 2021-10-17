package com.project.phantom.screens.base

import com.project.phantom.data.snippets.ProductRailSnippetData
import com.project.phantom.ui.snippets.ProductRailSnippetInteraction

open class SnippetInteractions : ProductRailSnippetInteraction {

    override fun onProductRailSnippetClicked(data: ProductRailSnippetData?) {
        ClickDataResolver.resolve(data?.phantomClickData)
    }
}