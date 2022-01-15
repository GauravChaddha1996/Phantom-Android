package com.project.phantom.ui.snippets.productDual

import com.project.phantom.theme.PhantomColorName.BLACK
import com.project.phantom.theme.PhantomColorName.GREY_600
import com.project.phantom.theme.PhantomColorName.GREY_800
import com.project.phantom.theme.PhantomColorName.GREY_900
import com.project.phantom.theme.PhantomFontStyle.LIGHT_200
import com.project.phantom.theme.PhantomFontStyle.MEDIUM_400
import com.project.phantom.theme.PhantomFontStyle.MEDIUM_500
import com.project.phantom.theme.PhantomFontStyle.REGULAR_200
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
            fontStyle = MEDIUM_400,
            colorName = GREY_900,
            defaultMaxLines = 2
        )
        shortDesc?.setDefaults(
            fontStyle = LIGHT_200,
            colorName = GREY_600,
            defaultMaxLines = 2
        )
        brand?.setDefaults(
            fontStyle = REGULAR_200,
            colorName = GREY_800,
            defaultMaxLines = 1
        )
        cost?.setDefaults(
            fontStyle = MEDIUM_500,
            colorName = BLACK
        )
    }
}
