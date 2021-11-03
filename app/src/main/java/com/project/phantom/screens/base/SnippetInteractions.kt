package com.project.phantom.screens.base

import com.project.phantom.data.snippets.CategoryRailSnippetData
import com.project.phantom.data.snippets.ProductDualSnippetData
import com.project.phantom.data.snippets.ProductFullSnippetData
import com.project.phantom.data.snippets.ProductRailSnippetData
import com.project.phantom.data.snippets.base.SectionHeaderSnippetData
import com.project.phantom.ui.snippets.*

open class SnippetInteractions :
    ProductRailSnippetInteraction,
    ProductFullSnippetInteraction,
    CategoryRailSnippetInteraction,
    ProductDualSnippetInteraction,
    SectionHeaderSnippetInteraction {

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

    override fun onSectionHeaderSnippetRightButtonClicked(data: SectionHeaderSnippetData?) {
        ClickDataResolver.resolve(data?.rightButton?.phantomClickData)
    }
}