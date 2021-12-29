package com.project.phantom.ui.snippets.productDual

import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomFontStyle
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
            fontStyle = PhantomFontStyle.MEDIUM_400,
            colorName = PhantomColorName.GREY_900,
            defaultMaxLines = 2
        )
        shortDesc?.setDefaults(
            fontStyle = PhantomFontStyle.LIGHT_200,
            colorName = PhantomColorName.GREY_600,
            defaultMaxLines = 2
        )
        brand?.setDefaults(
            fontStyle = PhantomFontStyle.REGULAR_200,
            colorName = PhantomColorName.GREY_800,
            defaultMaxLines = 1
        )
        cost?.setDefaults(
            fontStyle = PhantomFontStyle.MEDIUM_500,
            colorName = PhantomColorName.BLACK
        )
    }
}
