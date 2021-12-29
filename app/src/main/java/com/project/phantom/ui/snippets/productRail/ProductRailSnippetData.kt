package com.project.phantom.ui.snippets.productRail

import com.project.phantom.theme.PhantomColorName.BLACK
import com.project.phantom.theme.PhantomColorName.GREY_600
import com.project.phantom.theme.PhantomColorName.GREY_800
import com.project.phantom.theme.PhantomColorName.GREY_900
import com.project.phantom.theme.PhantomFontStyle.MEDIUM_300
import com.project.phantom.theme.PhantomFontStyle.MEDIUM_700
import com.project.phantom.theme.PhantomFontStyle.REGULAR_300
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_700
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
            fontStyle = MEDIUM_700,
            colorName = GREY_900,
            defaultMaxLines = 1
        )
        shortDesc?.setDefaults(
            fontStyle = REGULAR_300,
            colorName = GREY_600,
            defaultMaxLines = 2,
            defaultMinLines = 2
        )
        brandAndCategory?.setDefaults(
            fontStyle = MEDIUM_300,
            colorName = GREY_800,
            defaultMaxLines = 1
        )
        cost?.setDefaults(
            fontStyle = SEMIBOLD_700,
            colorName = BLACK
        )
    }
}
