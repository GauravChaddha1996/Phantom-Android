package com.project.phantom.data.snippets.base

import com.project.phantom.data.snippets.*
import com.project.phantom.data.snippets.base.SnippetApiData.Companion.SNIPPET_TYPE
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