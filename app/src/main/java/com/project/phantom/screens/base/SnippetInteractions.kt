package com.project.phantom.screens.base

import com.project.phantom.ui.snippets.categoryRail.CategoryRailSnippetData
import com.project.phantom.ui.snippets.categoryRail.CategoryRailSnippetInteraction
import com.project.phantom.ui.snippets.productDual.ProductDualSnippetData
import com.project.phantom.ui.snippets.productDual.ProductDualSnippetInteraction
import com.project.phantom.ui.snippets.productFull.ProductFullSnippetData
import com.project.phantom.ui.snippets.productFull.ProductFullSnippetInteraction
import com.project.phantom.ui.snippets.productRail.ProductRailSnippetData
import com.project.phantom.ui.snippets.productRail.ProductRailSnippetInteraction
import com.project.phantom.ui.snippets.sectionHeader.SectionHeaderSnippetData
import com.project.phantom.ui.snippets.sectionHeader.SectionHeaderSnippetInteraction

open class SnippetInteractions(private val activity: BaseActivity? = null) :
    ProductRailSnippetInteraction,
    ProductFullSnippetInteraction,
    CategoryRailSnippetInteraction,
    ProductDualSnippetInteraction,
    SectionHeaderSnippetInteraction {

    override fun onProductRailSnippetClicked(data: ProductRailSnippetData?) {
        ClickDataResolver.resolve(data?.clickData, activity)
    }

    override fun onProductFullSnippetClicked(data: ProductFullSnippetData?) {
        ClickDataResolver.resolve(data?.clickData, activity)
    }

    override fun onCategoryRailSnippetClicked(data: CategoryRailSnippetData?) {
        ClickDataResolver.resolve(data?.clickData, activity)
    }

    override fun onProductDualSnippetClicked(data: ProductDualSnippetData?) {
        ClickDataResolver.resolve(data?.clickData, activity)
    }

    override fun onSectionHeaderSnippetRightButtonClicked(data: SectionHeaderSnippetData?) {
        ClickDataResolver.resolve(data?.rightButton?.clickData, activity)
    }
}
