package com.project.phantom.ui.snippets.commons

import com.project.phantom.ui.snippets.categoryRail.CategoryRailSnippetApiData
import com.project.phantom.ui.snippets.commons.SnippetApiData.Companion.SNIPPET_TYPE
import com.project.phantom.ui.snippets.imagePager.ImagePagerSnippetData
import com.project.phantom.ui.snippets.productDual.ProductDualSnippetApiData
import com.project.phantom.ui.snippets.productFull.ProductFullSnippetApiData
import com.project.phantom.ui.snippets.productRail.ProductRailSnippetApiData
import com.project.phantom.ui.snippets.stepper.StepperSnippetData
import com.project.phantom.ui.snippets.textSection.TextSectionSnippetData
import com.squareup.moshi.Json
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory

open class SnippetApiData(
    @Json(name = SNIPPET_TYPE)
    val type: String? = null
) {
    companion object {
        const val SNIPPET_TYPE = "type"
    }
}


val SnippetApiDataPolymorphicAdapter: PolymorphicJsonAdapterFactory<SnippetApiData> =
    PolymorphicJsonAdapterFactory.of(SnippetApiData::class.java, SNIPPET_TYPE)
        .withSubtype(ProductRailSnippetApiData::class.java, SnippetType.ProductRailSnippet.name)
        .withSubtype(ProductFullSnippetApiData::class.java, SnippetType.ProductFullSnippet.name)
        .withSubtype(CategoryRailSnippetApiData::class.java, SnippetType.CategoryRailSnippet.name)
        .withSubtype(ProductDualSnippetApiData::class.java, SnippetType.ProductDualSnippet.name)
        .withSubtype(ImagePagerSnippetData::class.java, SnippetType.ImagePagerSnippet.name)
        .withSubtype(StepperSnippetData::class.java, SnippetType.StepperSnippet.name)
        .withSubtype(TextSectionSnippetData::class.java, SnippetType.TextSnippet.name)