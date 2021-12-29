package com.project.phantom.ui.image

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageData(
    @Json(name = "url") val url: String? = null
)
