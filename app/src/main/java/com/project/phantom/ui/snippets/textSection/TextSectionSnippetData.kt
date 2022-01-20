package com.project.phantom.ui.snippets.textSection

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import com.project.phantom.theme.PaddingStyle.large
import com.project.phantom.theme.PaddingStyle.medium
import com.project.phantom.theme.PaddingStyle.small
import com.project.phantom.theme.PhantomFontStyle.BodyLarge
import com.project.phantom.theme.PhantomFontStyle.BodyMedium
import com.project.phantom.theme.PhantomFontStyle.TitleLarge
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
        @Json(name = "subtitle") val subtitle: TextData? = null,
        @Json(name = "subtitle2") val subtitle2: TextData? = null
    ) : SnippetData() {

        @Transient
        var titlePaddingValues =
            PaddingValues(start = large, end = large, top = large, bottom = small)

        @Transient
        var subtitlePaddingValues =
            PaddingValues(start = large, end = large, top = 0.dp, bottom = medium)

        @Transient
        var subtitle2PaddingValues =
            PaddingValues(start = large, end = large, top = 0.dp, bottom = small)

        override fun setDefaults() {
            title?.setDefaults(fontStyle = TitleLarge)
            subtitle?.setDefaults(fontStyle = BodyMedium)
            subtitle2?.setDefaults(fontStyle = BodyLarge)
        }
    }
}
