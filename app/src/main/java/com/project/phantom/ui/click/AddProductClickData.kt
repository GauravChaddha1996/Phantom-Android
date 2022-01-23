package com.project.phantom.ui.click

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class AddProductClickData(
    @Json(name = "id") val productId: Int? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "short_desc") val shortDescription: String? = null,
    @Json(name = "brand_and_category") val brandAndCategory: String? = null,
    @Json(name = "image") val image: String? = null,
    @Json(name = "cost") val cost: Int? = null
) : ClickData()
