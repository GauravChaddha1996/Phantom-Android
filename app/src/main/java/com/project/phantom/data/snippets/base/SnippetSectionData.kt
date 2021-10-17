package com.project.phantom.data.snippets.base

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SnippetSectionData(
    @Json(name = "header_data")
    val headerData: SnippetSectionHeaderData? = null,

    @Json(name = "snippets")
    val snippets: List<SnippetNetworkData>? = null
)