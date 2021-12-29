package com.project.phantom.ui.snippets.commons

import com.project.phantom.ui.snippets.sectionHeader.SectionHeaderSnippetData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SnippetSectionData(
    @Json(name = "header_data")
    val headerData: SectionHeaderSnippetData? = null,

    @Json(name = "snippets")
    val snippetList: List<SnippetData>? = null
)
