package com.project.phantom.ui.snippets.commons

import com.project.phantom.ui.snippets.sectionHeader.SnippetSectionHeaderApiData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SnippetSectionData(
    @Json(name = "header_data")
    val headerApiData: SnippetSectionHeaderApiData? = null,

    @Json(name = "snippets")
    val snippetApiList: List<SnippetApiData>? = null
)