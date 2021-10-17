package com.project.phantom.data.snippets

import com.project.phantom.data.atoms.ImageData
import com.project.phantom.data.atoms.PhantomImageData
import com.project.phantom.data.atoms.PhantomTextData
import com.project.phantom.data.atoms.TextData
import com.project.phantom.data.atoms.click.OpenProductClickData
import com.project.phantom.data.atoms.click.PhantomClickData
import com.project.phantom.data.snippets.base.SnippetNetworkData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ProductRailSnippetNetworkData(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: TextData? = null,
    @Json(name = "short") val shortDesc: TextData? = null,
    @Json(name = "brand") val brand: TextData? = null,
    @Json(name = "category") val category: TextData? = null,
    @Json(name = "cost") val cost: TextData? = null,
    @Json(name = "image") val imageData: ImageData? = null
) : SnippetNetworkData()

class ProductRailSnippetData private constructor(
    val name: PhantomTextData,
    val shortDesc: PhantomTextData,
    val brand: PhantomTextData,
    val category: PhantomTextData,
    val cost: PhantomTextData,
    val imageData: PhantomImageData,
    val clickData: PhantomClickData
) {
    companion object {
        fun create(data: ProductRailSnippetNetworkData): ProductRailSnippetData {
            return ProductRailSnippetData(
                name = PhantomTextData.create(data.name),
                shortDesc = PhantomTextData.create(data.shortDesc),
                brand = PhantomTextData.create(data.brand),
                category = PhantomTextData.create(data.category),
                cost = PhantomTextData.create(data.cost),
                imageData = PhantomImageData.create(data.imageData),
                clickData = PhantomClickData(OpenProductClickData(data.id))
            )
        }
    }
}