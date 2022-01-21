package com.project.phantom.ui.click

import com.squareup.moshi.Json
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory

open class ClickData {
    companion object {
        const val CLICK_TYPE = "type"
    }

    @Json(name = CLICK_TYPE)
    val type: String? = null
}

val ClickDataPolymorphicAdapter: PolymorphicJsonAdapterFactory<ClickData> =
    PolymorphicJsonAdapterFactory.of(ClickData::class.java, ClickData.CLICK_TYPE)
        .withSubtype(OpenProductClickData::class.java, ClickTypes.OPEN_PRODUCT.name)
        .withSubtype(OpenCategoryClickData::class.java, ClickTypes.OPEN_CATEGORY.name)
