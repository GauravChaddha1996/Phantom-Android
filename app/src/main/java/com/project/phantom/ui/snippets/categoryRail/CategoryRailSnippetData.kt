package com.project.phantom.ui.snippets.categoryRail

import androidx.compose.ui.text.style.TextOverflow
import com.project.phantom.theme.PhantomColorName.GREY_900
import com.project.phantom.theme.PhantomColorName.RED_100
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_940
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_950
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
        firstCharacter?.setDefaults(fontStyle = SEMIBOLD_950)
        name?.setDefaults(
            fontStyle = SEMIBOLD_940,
            colorName = GREY_900,
            overflow = TextOverflow.Visible
        )
        bgColor?.setDefaults(defaultColorName = RED_100)
    }
}
