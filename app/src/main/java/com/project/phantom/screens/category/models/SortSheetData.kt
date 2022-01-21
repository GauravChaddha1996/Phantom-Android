package com.project.phantom.screens.category.models

import com.project.phantom.theme.PhantomFontStyle.TitleSmall
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SortSheetData(
    @Json(name = "methods") val methods: List<SortMethodData>? = null
) : SnippetData() {
    override fun setDefaults() {
        methods?.forEach { it.setDefaults() }
    }
}

fun SortSheetData?.getSelectedSortMethod() = this?.methods?.firstOrNull { it.selected == true }

@JsonClass(generateAdapter = true)
data class SortMethodData(
    @Json(name = "id") val id: Int? = null,
    @Json(name = "name") val name: TextData? = null,
    @Json(name = "selected") var selected: Boolean? = null
) : SnippetData() {

    override fun setDefaults() {
        name?.setDefaults(fontStyle = TitleSmall)
    }
}
