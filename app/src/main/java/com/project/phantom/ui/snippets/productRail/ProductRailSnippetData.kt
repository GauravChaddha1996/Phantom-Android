package com.project.phantom.ui.snippets.productRail

import com.project.phantom.PhantomApplication
import com.project.phantom.R
import com.project.phantom.theme.color.PhantomColor
import com.project.phantom.theme.font.PhantomTextStyle
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
    @Json(name = "click") val clickData: ClickData? = null,
    @Json(name = "new_tag") var newTag: TextData? = null
) : SnippetData() {

    override fun setDefaults() {
        name?.setDefaults(
            textStyle = PhantomTextStyle.TitleSemiLarge,
            color = PhantomColor.OnSurface,
            defaultMaxLines = 1
        )
        shortDesc?.setDefaults(
            textStyle = PhantomTextStyle.BodyMedium,
            color = PhantomColor.OnSurface,
            defaultMaxLines = 2,
            defaultMinLines = 2
        )
        brandAndCategory?.setDefaults(
            textStyle = PhantomTextStyle.BodyLarge,
            color = PhantomColor.OnSurface,
            defaultMaxLines = 1
        )
        cost?.setDefaults(
            textStyle = PhantomTextStyle.TitleSemiLarge,
            color = PhantomColor.OnSurfaceVariant
        )
        newTag = TextData().setDefaults(
            text = PhantomApplication.INSTANCE.getString(R.string.new3),
            textStyle = PhantomTextStyle.LabelLarge,
            color = PhantomColor.OnPrimary
        )
    }
}
