package com.project.phantom.ui.snippets.sectionHeader

import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.ui.button.ButtonData
import com.project.phantom.ui.button.PhantomButtonData
import com.project.phantom.ui.snippets.commons.SnippetApiData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.PhantomTextData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SnippetSectionHeaderApiData(
    @Json(name = "title") val title: TextData? = null,
    @Json(name = "subtitle") val subtitle: TextData? = null,
    @Json(name = "right_button") val rightButton: ButtonData? = null
) : SnippetApiData()

class SectionHeaderSnippetData(
    val title: PhantomTextData,
    val subtitle: PhantomTextData,
    val rightButton: PhantomButtonData
) : SnippetData() {
    companion object {
        fun create(apiData: SnippetSectionHeaderApiData): SectionHeaderSnippetData {
            return SectionHeaderSnippetData(
                title = PhantomTextData.create(apiData.title, PhantomFontStyle.SEMIBOLD_700),
                subtitle = PhantomTextData.create(apiData.subtitle),
                rightButton = PhantomButtonData.create(apiData.rightButton)
            )
        }
    }
}
