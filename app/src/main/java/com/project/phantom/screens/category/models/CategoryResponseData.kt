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

    @Json(name = "page_title")
    val pageTitle: TextData? = null,

    @Json(name = "snippet_section_header")
    val snippetSectionHeader: TextData? = null,

    @Json(name = "snippet_section_list")
    val snippetSectionList: List<SnippetSectionData>? = null,

    @Json(name = "sort_sheet_ui_data")
    val sortSheetData: SortSheetData? = null
)
