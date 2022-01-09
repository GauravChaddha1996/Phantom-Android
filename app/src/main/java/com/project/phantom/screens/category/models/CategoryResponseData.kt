package com.project.phantom.screens.category.models

import com.project.phantom.ui.snippets.commons.SnippetSectionData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CategoryResponseData(
    @Json(name = "status")
    val status: String? = null,

    @Json(name = "message")
    val message: String? = null,

    @Json(name = "category_title")
    val categoryTitle: TextData? = null,

    @Json(name = "category_subtitle")
    val categorySubtitle: TextData? = null,

    @Json(name = "snippet_section_list")
    val snippetSectionList: List<SnippetSectionData>? = null
)
