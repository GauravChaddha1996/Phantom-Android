package com.project.phantom.ui.snippets.sectionHeader

import androidx.compose.foundation.layout.PaddingValues
import com.project.phantom.theme.font.PhantomTextStyle
import com.project.phantom.ui.button.ButtonData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SectionHeaderSnippetData(
    @Json(name = "title") val title: TextData? = null,
    @Json(name = "right_button") val rightButton: ButtonData? = null
) : SnippetData() {

    @Transient
    var paddingValues: PaddingValues? = null

    override fun setDefaults() {
        title?.setDefaults(textStyle = PhantomTextStyle.TitleSemiLarge, defaultMaxLines = 1)
    }
}
