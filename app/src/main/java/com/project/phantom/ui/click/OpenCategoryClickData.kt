package com.project.phantom.ui.click

import com.project.phantom.ui.commons.ColorData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class OpenCategoryClickData(
    @Json(name = "category_id") val categoryId: Int? = null,
    @Json(name = "category_color") val categoryColor: ColorData? = null
) : ClickData()
