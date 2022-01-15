package com.project.phantom.ui.snippets.textSection

import com.project.phantom.theme.PhantomFontStyle.REGULAR_400
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_700
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class TextSectionSnippetData(
    @Json(name = "text_section_arr") val textSectionArr: List<TextSnippet>? = null
) : SnippetData() {

    override fun setDefaults() {
        textSectionArr?.forEach { it.setDefaults() }
    }

    class TextSnippet(
        @Json(name = "title") val title: TextData? = null,
        @Json(name = "subtitle") val subtitle: TextData? = null
    ) : SnippetData() {

        override fun setDefaults() {
            title?.setDefaults(fontStyle = SEMIBOLD_700)
            subtitle?.setDefaults(fontStyle = REGULAR_400)
        }
    }
}
