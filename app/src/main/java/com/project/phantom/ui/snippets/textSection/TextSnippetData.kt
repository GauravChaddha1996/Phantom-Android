package com.project.phantom.ui.snippets.textSection

import androidx.compose.foundation.layout.PaddingValues
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.font.PhantomTextStyle
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class TextSnippetData(
    @Json(name = "title") val title: TextData? = null,
    @Json(name = "subtitle") val subtitle: TextData? = null,
    @Json(name = "subtitle2") val subtitle2: TextData? = null,
    @Json(name = "bottom_separator") val bottomSeparator: Boolean? = null
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
        title?.setDefaults(textStyle = PhantomTextStyle.TitleSemiLarge)
        subtitle?.setDefaults(textStyle = PhantomTextStyle.BodyLarge)
        subtitle2?.setDefaults(textStyle = PhantomTextStyle.BodyExtra)

        if (title == null && subtitle != null) {
            subtitlePaddingValues = PaddingValues(
                start = PaddingStyle.large,
                end = PaddingStyle.large,
                top = PaddingStyle.large,
                bottom = PaddingStyle.medium
            )
        }
    }
}
