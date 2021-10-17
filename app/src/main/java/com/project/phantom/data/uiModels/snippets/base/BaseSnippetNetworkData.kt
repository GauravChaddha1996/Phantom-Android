package com.project.phantom.data.uiModels.snippets.base

import com.project.phantom.data.uiModels.snippets.*
import com.project.phantom.data.uiModels.snippets.base.BaseSnippetNetworkData.Companion.SNIPPET_TYPE
import com.squareup.moshi.Json
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory

open class BaseSnippetNetworkData {
    companion object {
        const val SNIPPET_TYPE = "type"
    }

    @Json(name = SNIPPET_TYPE)
    val type: String? = null
}


val BaseSnippetNetworkDataPolymorphicAdapter: PolymorphicJsonAdapterFactory<BaseSnippetNetworkData> =
    PolymorphicJsonAdapterFactory.of(BaseSnippetNetworkData::class.java, SNIPPET_TYPE)
        .withSubtype(CategoryRailSnippet::class.java, SnippetType.CategoryRailSnippet.name)
        .withSubtype(ImagePagerSnippet::class.java, SnippetType.ImagePagerSnippet.name)
        .withSubtype(ProductDualSnippet::class.java, SnippetType.ProductDualSnippet.name)
        .withSubtype(ProductFullSnippet::class.java, SnippetType.ProductFullSnippet.name)
        .withSubtype(ProductRailSnippet::class.java, SnippetType.ProductRailSnippet.name)
        .withSubtype(StepperSnippet::class.java, SnippetType.StepperSnippet.name)
        .withSubtype(TextSectionSnippet::class.java, SnippetType.TextSnippet.name)