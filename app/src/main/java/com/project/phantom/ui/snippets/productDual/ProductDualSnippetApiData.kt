package com.project.phantom.ui.snippets.productDual

import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomFontStyle
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
class ProductDualSnippetApiData(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: TextData? = null,
    @Json(name = "short_desc") val shortDesc: TextData? = null,
    @Json(name = "brand") val brand: TextData? = null,
    @Json(name = "cost") val cost: TextData? = null,
    @Json(name = "image") val imageData: ImageData? = null,
    @Json(name = "click") val clickData: ClickData? = null
) : SnippetApiData()


class ProductDualSnippetData private constructor(
    val name: PhantomTextData,
    val shortDesc: PhantomTextData,
    val brand: PhantomTextData,
    val cost: PhantomTextData,
    val imageData: PhantomImageData,
    val phantomClickData: PhantomClickData
) : SnippetData() {
    companion object {
        fun create(data: ProductDualSnippetApiData): ProductDualSnippetData {
            return ProductDualSnippetData(
                name = PhantomTextData.create(
                    data = data.name,
                    fontStyle = PhantomFontStyle.MEDIUM_400,
                    colorName = PhantomColorName.GREY_900,
                    maxLines = 2
                ),
                shortDesc = PhantomTextData.create(
                    data = data.shortDesc,
                    fontStyle = PhantomFontStyle.LIGHT_200,
                    colorName = PhantomColorName.GREY_600,
                    maxLines = 2
                ),
                brand = PhantomTextData.create(
                    data = data.brand,
                    fontStyle = PhantomFontStyle.REGULAR_200,
                    colorName = PhantomColorName.GREY_800,
                    maxLines = 1
                ),
                cost = PhantomTextData.create(
                    data = data.cost,
                    fontStyle = PhantomFontStyle.MEDIUM_500,
                    colorName = PhantomColorName.BLACK
                ),
                imageData = PhantomImageData.create(data = data.imageData),
                phantomClickData = PhantomClickData(clickData = data.clickData)
            )
        }
    }
}
