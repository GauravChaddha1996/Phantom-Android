package com.project.phantom.data.uiModels.snippets.base

import com.project.phantom.data.uiModels.atoms.ButtonData
import com.project.phantom.data.uiModels.atoms.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SnippetSectionHeader {
    @Json(name = "title")
    val title: TextData? = null

    @Json(name = "subtitle")
    val subtitle: TextData? = null

    @Json(name = "right_button")
    val rightButton: ButtonData? = null
}