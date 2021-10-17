package com.project.phantom.data.atoms.click

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class OpenProductClickData(
    @Json(name = "product_id") val productId: Int? = null
) : ClickData()