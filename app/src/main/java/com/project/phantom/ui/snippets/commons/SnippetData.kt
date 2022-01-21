package com.project.phantom.ui.snippets.commons

import com.project.phantom.ui.snippets.categoryRail.CategoryRailSnippetData
import com.project.phantom.ui.snippets.commons.SnippetData.Companion.SNIPPET_TYPE
import com.project.phantom.ui.snippets.imagePager.ImagePagerSnippetData
import com.project.phantom.ui.snippets.productDual.ProductDualSnippetData
import com.project.phantom.ui.snippets.productFull.ProductFullSnippetData
import com.project.phantom.ui.snippets.productRail.ProductRailSnippetData
import com.project.phantom.ui.snippets.stepper.StepperSnippetData
import com.project.phantom.ui.snippets.textSection.TextSnippetData
import com.squareup.moshi.Json
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory

abstract class SnippetData(
    @Json(name = SNIPPET_TYPE)
    val type: String? = null
) {
    companion object {
        const val SNIPPET_TYPE = "type"
    }

    abstract fun setDefaults()
}

val SnippetDataPolymorphicAdapter: PolymorphicJsonAdapterFactory<SnippetData> =
    PolymorphicJsonAdapterFactory.of(SnippetData::class.java, SNIPPET_TYPE)
        .withSubtype(ProductRailSnippetData::class.java, SnippetType.ProductRailSnippet.name)
        .withSubtype(ProductFullSnippetData::class.java, SnippetType.ProductFullSnippet.name)
        .withSubtype(CategoryRailSnippetData::class.java, SnippetType.CategoryRailSnippet.name)
        .withSubtype(ProductDualSnippetData::class.java, SnippetType.ProductDualSnippet.name)
        .withSubtype(ImagePagerSnippetData::class.java, SnippetType.ImagePagerSnippet.name)
        .withSubtype(StepperSnippetData::class.java, SnippetType.StepperSnippet.name)
        .withSubtype(TextSnippetData::class.java, SnippetType.TextSnippet.name)
