package com.project.phantom.data.snippets.base

import com.project.phantom.data.snippets.*
import com.project.phantom.data.snippets.base.SnippetNetworkData.Companion.SNIPPET_TYPE
import com.squareup.moshi.Json
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory

open class SnippetNetworkData(
    @Json(name = SNIPPET_TYPE)
    val type: String? = null
) {
    companion object {
        const val SNIPPET_TYPE = "type"
    }
}


val SnippetNetworkDataPolymorphicAdapter: PolymorphicJsonAdapterFactory<SnippetNetworkData> =
    PolymorphicJsonAdapterFactory.of(SnippetNetworkData::class.java, SNIPPET_TYPE)
        .withSubtype(CategoryRailSnippetData::class.java, SnippetType.CategoryRailSnippet.name)
        .withSubtype(ImagePagerSnippetData::class.java, SnippetType.ImagePagerSnippet.name)
        .withSubtype(ProductDualSnippetData::class.java, SnippetType.ProductDualSnippet.name)
        .withSubtype(ProductFullSnippetData::class.java, SnippetType.ProductFullSnippet.name)
        .withSubtype(ProductRailSnippetNetworkData::class.java, SnippetType.ProductRailSnippet.name)
        .withSubtype(StepperSnippetData::class.java, SnippetType.StepperSnippet.name)
        .withSubtype(TextSectionSnippetData::class.java, SnippetType.TextSnippet.name)