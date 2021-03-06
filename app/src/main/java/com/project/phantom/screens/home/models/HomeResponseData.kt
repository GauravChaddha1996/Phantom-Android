package com.project.phantom.screens.home.models

import com.project.phantom.ui.snippets.commons.SnippetSectionData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class HomeResponseData(
    @Json(name = "status")
    val status: String? = null,

    @Json(name = "message")
    val message: String? = null,

    @Json(name = "snippet_section_list")
    val snippetSectionList: List<SnippetSectionData>? = null
)
