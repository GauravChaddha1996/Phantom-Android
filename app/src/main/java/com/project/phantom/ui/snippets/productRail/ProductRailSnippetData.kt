package com.project.phantom.ui.snippets.productRail

import com.project.phantom.theme.PhantomColorName.OnSurface
import com.project.phantom.theme.PhantomColorName.OnSurfaceVariant
import com.project.phantom.theme.PhantomFontStyle.BodyLarge
import com.project.phantom.theme.PhantomFontStyle.BodyMedium
import com.project.phantom.theme.PhantomFontStyle.DisplayMedium
import com.project.phantom.theme.PhantomFontStyle.TitleLarge
import com.project.phantom.ui.click.ClickData
import com.project.phantom.ui.image.ImageData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductRailSnippetData(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: TextData? = null,
    @Json(name = "short_desc") val shortDesc: TextData? = null,
    @Json(name = "brand_and_category") val brandAndCategory: TextData? = null,
    @Json(name = "cost") val cost: TextData? = null,
    @Json(name = "image") val imageData: ImageData? = null,
    @Json(name = "click") val clickData: ClickData? = null
) : SnippetData() {

    override fun setDefaults() {
        name?.setDefaults(
            fontStyle = TitleLarge,
            colorName = OnSurface,
            defaultMaxLines = 1
        )
        shortDesc?.setDefaults(
            fontStyle = BodyMedium,
            colorName = OnSurface,
            defaultMaxLines = 2,
            defaultMinLines = 2
        )
        brandAndCategory?.setDefaults(
            fontStyle = BodyLarge,
            colorName = OnSurface,
            defaultMaxLines = 1
        )
        cost?.setDefaults(
            fontStyle = DisplayMedium,
            colorName = OnSurfaceVariant
        )
    }
}
