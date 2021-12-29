package com.project.phantom.ui.snippets.categoryRail

import androidx.compose.ui.text.style.TextOverflow
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.ui.click.ClickData
import com.project.phantom.ui.commons.ColorData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CategoryRailSnippetData(
    @Json(name = "id") val id: Int,
    @Json(name = "first_character") val firstCharacter: TextData? = null,
    @Json(name = "name") val name: TextData? = null,
    @Json(name = "bg_color") val bgColor: ColorData? = null,
    @Json(name = "click") val clickData: ClickData? = null
) : SnippetData() {

    override fun setDefaults() {
        firstCharacter?.setDefaults(fontStyle = PhantomFontStyle.SEMIBOLD_950)
        name?.setDefaults(
            fontStyle = PhantomFontStyle.SEMIBOLD_940,
            colorName = PhantomColorName.GREY_900,
            overflow = TextOverflow.Visible
        )
        bgColor?.setDefaults(defaultColorName = PhantomColorName.RED_100)
    }
}
