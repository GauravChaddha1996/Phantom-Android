package com.project.phantom.data.uiModels.snippets

import com.project.phantom.data.uiModels.atoms.ImageData
import com.project.phantom.data.uiModels.atoms.TextData
import com.project.phantom.data.uiModels.snippets.base.BaseSnippetNetworkData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ProductRailSnippet(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: TextData? = null,
    @Json(name = "short") val shortDesc: TextData? = null,
    @Json(name = "brand") val brand: TextData? = null,
    @Json(name = "category") val category: TextData? = null,
    @Json(name = "cost") val cost: TextData? = null,
    @Json(name = "image") val imageData: ImageData? = null
) : BaseSnippetNetworkData()
