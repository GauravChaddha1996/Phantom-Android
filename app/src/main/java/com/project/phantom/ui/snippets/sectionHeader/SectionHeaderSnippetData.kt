package com.project.phantom.ui.snippets.sectionHeader

import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.ui.button.ButtonData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SectionHeaderSnippetData(
    @Json(name = "title") val title: TextData? = null,
    @Json(name = "subtitle") val subtitle: TextData? = null,
    @Json(name = "right_button") val rightButton: ButtonData? = null
) : SnippetData() {
    override fun setDefaults() {
        title?.setDefaults(fontStyle = PhantomFontStyle.SEMIBOLD_700)
    }
}
