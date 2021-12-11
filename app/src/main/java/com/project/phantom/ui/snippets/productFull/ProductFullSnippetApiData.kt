package com.project.phantom.ui.snippets.productFull

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
class ProductFullSnippetApiData(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: TextData? = null,
    @Json(name = "long_desc") val longDesc: TextData? = null,
    @Json(name = "brand_and_category") val brandAndCategory: TextData? = null,
    @Json(name = "cost") val cost: TextData? = null,
    @Json(name = "image") val imageData: ImageData? = null,
    @Json(name = "click") val clickData: ClickData? = null
) : SnippetApiData()

class ProductFullSnippetData private constructor(
    val name: PhantomTextData,
    val longDesc: PhantomTextData,
    val brandAndCategory: PhantomTextData,
    val cost: PhantomTextData,
    val imageData: PhantomImageData,
    val phantomClickData: PhantomClickData
) : SnippetData() {
    companion object {
        fun create(data: ProductFullSnippetApiData): ProductFullSnippetData {
            return ProductFullSnippetData(
                name = PhantomTextData.create(
                    data = data.name,
                    fontStyle = PhantomFontStyle.MEDIUM_700,
                    colorName = PhantomColorName.GREY_900,
                    maxLines = 1
                ),
                longDesc = PhantomTextData.create(
                    data = data.longDesc,
                    fontStyle = PhantomFontStyle.REGULAR_300,
                    colorName = PhantomColorName.GREY_600,
                    maxLines = 4
                ),
                brandAndCategory = PhantomTextData.create(
                    data = data.brandAndCategory,
                    fontStyle = PhantomFontStyle.MEDIUM_300,
                    colorName = PhantomColorName.GREY_800,
                    maxLines = 1
                ),
                cost = PhantomTextData.create(
                    data = data.cost,
                    fontStyle = PhantomFontStyle.SEMIBOLD_700,
                    colorName = PhantomColorName.BLACK
                ),
                imageData = PhantomImageData.create(data = data.imageData),
                phantomClickData = PhantomClickData(data.clickData)
            )
        }
    }
}
