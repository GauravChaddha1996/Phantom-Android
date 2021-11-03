package com.project.phantom.data.snippets

import com.project.phantom.data.atoms.ImageData
import com.project.phantom.data.atoms.PhantomImageData
import com.project.phantom.data.atoms.PhantomTextData
import com.project.phantom.data.atoms.TextData
import com.project.phantom.data.atoms.click.OpenProductClickData
import com.project.phantom.data.atoms.click.PhantomClickData
import com.project.phantom.data.snippets.base.SnippetApiData
import com.project.phantom.data.snippets.base.SnippetData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ProductDualSnippetApiData(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: TextData? = null,
    @Json(name = "short_desc") val shortDesc: TextData? = null,
    @Json(name = "brand") val brand: TextData? = null,
    @Json(name = "cost") val cost: TextData? = null,
    @Json(name = "image") val imageData: ImageData? = null
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
                phantomClickData = PhantomClickData(OpenProductClickData(data.id))
            )
        }
    }
}
