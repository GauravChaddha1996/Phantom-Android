package com.project.phantom.ui.snippets.productFull

import com.project.phantom.theme.color.PhantomColor
import com.project.phantom.theme.font.PhantomTextStyle
import com.project.phantom.ui.click.ClickData
import com.project.phantom.ui.image.ImageData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductFullSnippetData(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: TextData? = null,
    @Json(name = "long_desc") val longDesc: TextData? = null,
    @Json(name = "brand_and_category") val brandAndCategory: TextData? = null,
    @Json(name = "cost") val cost: TextData? = null,
    @Json(name = "image") val imageData: ImageData? = null,
    @Json(name = "click") val clickData: ClickData? = null
) : SnippetData() {

    override fun setDefaults() {
        name?.setDefaults(
            textStyle = PhantomTextStyle.TitleSemiLarge,
            defaultMaxLines = 1
        )
        longDesc?.setDefaults(
            textStyle = PhantomTextStyle.BodyMedium,
            defaultMaxLines = 4
        )
        brandAndCategory?.setDefaults(
            textStyle = PhantomTextStyle.BodyLarge,
            defaultMaxLines = 1
        )
        cost?.setDefaults(
            textStyle = PhantomTextStyle.TitleSemiLarge,
            color = PhantomColor.OnSurfaceVariant
        )
    }
}
