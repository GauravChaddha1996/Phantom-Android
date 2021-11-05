package com.project.phantom.ui.click

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class OpenCategoryClickData(
    @Json(name = "category_id") val categoryId: Int? = null
) : ClickData()