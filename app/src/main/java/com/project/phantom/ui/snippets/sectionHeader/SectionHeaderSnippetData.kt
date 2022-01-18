package com.project.phantom.ui.snippets.sectionHeader

import androidx.compose.foundation.layout.PaddingValues
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.PhantomFontStyle.TitleLarge
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

    @Transient
    var paddingValues: PaddingValues = PaddingValues(start = PaddingStyle.large)

    override fun setDefaults() {
        title?.setDefaults(fontStyle = TitleLarge)
    }
}
