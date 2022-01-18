package com.project.phantom.ui.snippets.productDual

import com.project.phantom.theme.PhantomColorName.OnSurface
import com.project.phantom.theme.PhantomColorName.OnSurfaceVariant
import com.project.phantom.theme.PhantomFontStyle.BodyMedium
import com.project.phantom.theme.PhantomFontStyle.BodySmall
import com.project.phantom.theme.PhantomFontStyle.LabelLarge
import com.project.phantom.theme.PhantomFontStyle.TitleMedium
import com.project.phantom.ui.click.ClickData
import com.project.phantom.ui.image.ImageData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductDualSnippetData(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: TextData? = null,
    @Json(name = "short_desc") val shortDesc: TextData? = null,
    @Json(name = "brand") val brand: TextData? = null,
    @Json(name = "cost") val cost: TextData? = null,
    @Json(name = "image") val imageData: ImageData? = null,
    @Json(name = "click") val clickData: ClickData? = null
) : SnippetData() {
    override fun setDefaults() {
        name?.setDefaults(
            fontStyle = TitleMedium,
            colorName = OnSurface,
            defaultMaxLines = 2
        )
        shortDesc?.setDefaults(
            fontStyle = BodySmall,
            colorName = OnSurface,
            defaultMaxLines = 2
        )
        brand?.setDefaults(
            fontStyle = BodyMedium,
            colorName = OnSurface,
            defaultMaxLines = 1
        )
        cost?.setDefaults(
            fontStyle = LabelLarge,
            colorName = OnSurfaceVariant
        )
    }
}
