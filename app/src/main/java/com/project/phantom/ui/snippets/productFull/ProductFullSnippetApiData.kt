package com.project.phantom.ui.snippets.productFull

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
    @Json(name = "brand") val brand: TextData? = null,
    @Json(name = "category") val category: TextData? = null,
    @Json(name = "cost") val cost: TextData? = null,
    @Json(name = "image") val imageData: ImageData? = null,
    @Json(name = "click") val clickData: ClickData? = null
) : SnippetApiData()

class ProductFullSnippetData private constructor(
    val name: PhantomTextData,
    val longDesc: PhantomTextData,
    val brand: PhantomTextData,
    val category: PhantomTextData,
    val cost: PhantomTextData,
    val imageData: PhantomImageData,
    val phantomClickData: PhantomClickData
) : SnippetData() {
    companion object {
        fun create(data: ProductFullSnippetApiData): ProductFullSnippetData {
            return ProductFullSnippetData(
                name = PhantomTextData.create(data.name),
                longDesc = PhantomTextData.create(data.longDesc),
                brand = PhantomTextData.create(data.brand),
                category = PhantomTextData.create(data.category),
                cost = PhantomTextData.create(data.cost),
                imageData = PhantomImageData.create(data.imageData),
                phantomClickData = PhantomClickData(data.clickData)
            )
        }
    }
}