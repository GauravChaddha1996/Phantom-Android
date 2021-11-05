package com.project.phantom.ui.snippets.productDual

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
                name = PhantomTextData.create(data.name),
                shortDesc = PhantomTextData.create(data.shortDesc),
                brand = PhantomTextData.create(data.brand),
                cost = PhantomTextData.create(data.cost),
                imageData = PhantomImageData.create(data.imageData),
                phantomClickData = PhantomClickData(data.clickData)
            )
        }
    }
}
