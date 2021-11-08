package com.project.phantom.ui.snippets.productRail

import com.project.phantom.theme.PhantomColorName.*
import com.project.phantom.theme.PhantomFontStyle.*
import com.project.phantom.ui.click.ClickData
import com.project.phantom.ui.click.PhantomClickData
import com.project.phantom.ui.image.ImageData
import com.project.phantom.ui.image.PhantomImageData
import com.project.phantom.ui.snippets.commons.SnippetApiData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.PhantomTextData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ProductRailSnippetApiData(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: TextData? = null,
    @Json(name = "short_desc") val shortDesc: TextData? = null,
    @Json(name = "brand_and_category") val brandAndCategory: TextData? = null,
    @Json(name = "cost") val cost: TextData? = null,
    @Json(name = "image") val imageData: ImageData? = null,
    @Json(name = "click") val clickData: ClickData? = null
) : SnippetApiData()

class ProductRailSnippetData private constructor(
    val name: PhantomTextData,
    val shortDesc: PhantomTextData,
    val brandAndCategory: PhantomTextData,
    val cost: PhantomTextData,
    val imageData: PhantomImageData,
    val phantomClickData: PhantomClickData
) : SnippetData() {
    companion object {
        fun create(data: ProductRailSnippetApiData): ProductRailSnippetData {
            return ProductRailSnippetData(
                name = PhantomTextData.create(
                    data = data.name,
                    fontStyle = MEDIUM_700,
                    colorName = GREY_900,
                    maxLines = 1
                ),
                shortDesc = PhantomTextData.create(
                    data = data.shortDesc,
                    fontStyle = REGULAR_300,
                    colorName = GREY_600,
                    maxLines = 2,
                    minLines = 2
                ),
                brandAndCategory = PhantomTextData.create(
                    data = data.brandAndCategory,
                    fontStyle = MEDIUM_300,
                    colorName = GREY_800,
                    maxLines = 1
                ),
                cost = PhantomTextData.create(
                    data.cost,
                    SEMIBOLD_700,
                    BLACK
                ),
                imageData = PhantomImageData.create(data.imageData),
                phantomClickData = PhantomClickData(data.clickData)
            )
        }
    }
}