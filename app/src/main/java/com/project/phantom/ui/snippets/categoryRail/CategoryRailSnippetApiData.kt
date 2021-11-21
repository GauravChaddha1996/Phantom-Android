package com.project.phantom.ui.snippets.categoryRail

import androidx.compose.ui.text.style.TextOverflow
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.ui.click.ClickData
import com.project.phantom.ui.click.PhantomClickData
import com.project.phantom.ui.commons.ColorData
import com.project.phantom.ui.commons.PhantomColorData
import com.project.phantom.ui.snippets.commons.SnippetApiData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.PhantomTextData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CategoryRailSnippetApiData(
    @Json(name = "id") val id: Int,
    @Json(name = "first_character") val firstCharacter: TextData? = null,
    @Json(name = "name") val name: TextData? = null,
    @Json(name = "bg_color") val bgColor: ColorData? = null,
    @Json(name = "click") val clickData: ClickData? = null,
) : SnippetApiData()

class CategoryRailSnippetData(
    val firstCharacter: PhantomTextData,
    val name: PhantomTextData,
    val bgColor: PhantomColorData,
    val phantomClickData: PhantomClickData
) : SnippetData() {
    companion object {
        fun create(data: CategoryRailSnippetApiData): CategoryRailSnippetData {
            return CategoryRailSnippetData(
                firstCharacter = PhantomTextData.create(
                    data = data.firstCharacter,
                    fontStyle = PhantomFontStyle.SEMIBOLD_950
                ),
                name = PhantomTextData.create(
                    data = data.name,
                    fontStyle = PhantomFontStyle.SEMIBOLD_940,
                    colorName = PhantomColorName.GREY_900,
                    overflow = TextOverflow.Visible
                ),
                bgColor = PhantomColorData.create(
                    data = data.bgColor,
                    defaultColorName = PhantomColorName.RED_100
                ),
                phantomClickData = PhantomClickData(data.clickData)
            )
        }
    }
}