package com.project.phantom.data.uiModels.snippets.base

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SnippetSectionData {
    @Json(name = "header_data")
    val header: SnippetSectionHeader? = null

    @Json(name = "snippets")
    val snippets: List<BaseSnippetNetworkData>? = null
}