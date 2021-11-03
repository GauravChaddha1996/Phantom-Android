package com.project.phantom.data.snippets.base

import com.project.phantom.data.atoms.ButtonData
import com.project.phantom.data.atoms.PhantomButtonData
import com.project.phantom.data.atoms.PhantomTextData
import com.project.phantom.data.atoms.TextData
import com.project.phantom.theme.PhantomFontStyle
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
                title = PhantomTextData.create(apiData.title, PhantomFontStyle.SEMIBOLD_600),
                subtitle = PhantomTextData.create(apiData.subtitle),
                rightButton = PhantomButtonData.create(apiData.rightButton)
            )
        }
    }
}