package com.project.phantom.ui.snippets.categoryRail

import androidx.compose.ui.text.style.TextOverflow
import com.project.phantom.theme.PhantomColorName.OnSurfaceVariant
import com.project.phantom.theme.PhantomFontStyle.HeadlineLarge
import com.project.phantom.theme.PhantomFontStyle.HeadlineMedium
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
        firstCharacter?.setDefaults(fontStyle = HeadlineLarge)
        name?.setDefaults(
            fontStyle = HeadlineMedium,
            colorName = OnSurfaceVariant,
            overflow = TextOverflow.Visible
        )
    }
}
