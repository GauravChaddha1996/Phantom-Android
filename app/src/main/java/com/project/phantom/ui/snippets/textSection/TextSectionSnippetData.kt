package com.project.phantom.ui.snippets.textSection

import androidx.compose.foundation.layout.PaddingValues
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.font.PhantomTextStyle
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
            PaddingValues(
                start = PaddingStyle.large,
                end = PaddingStyle.large,
                top = PaddingStyle.large,
                bottom = PaddingStyle.small
            )

        @Transient
        var subtitlePaddingValues =
            PaddingValues(
                start = PaddingStyle.large,
                end = PaddingStyle.large,
                top = PaddingStyle.zero,
                bottom = PaddingStyle.medium
            )

        @Transient
        var subtitle2PaddingValues =
            PaddingValues(
                start = PaddingStyle.large,
                end = PaddingStyle.large,
                top = PaddingStyle.zero,
                bottom = PaddingStyle.small
            )

        override fun setDefaults() {
            title?.setDefaults(textStyle = PhantomTextStyle.TitleLarge)
            subtitle?.setDefaults(textStyle = PhantomTextStyle.BodyMedium)
            subtitle2?.setDefaults(textStyle = PhantomTextStyle.BodyLarge)
        }
    }
}
