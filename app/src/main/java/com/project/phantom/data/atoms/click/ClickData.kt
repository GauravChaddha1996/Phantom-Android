package com.project.phantom.data.atoms.click

import com.project.phantom.data.snippets.base.SnippetType
import com.squareup.moshi.Json
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory

open class ClickData {
    companion object {
        const val CLICK_TYPE = "type"
    }

    @Json(name = CLICK_TYPE)
    val type: String? = null
}

val ClickDataPolymorphicAdapter: PolymorphicJsonAdapterFactory<ClickData>? =
    PolymorphicJsonAdapterFactory.of(ClickData::class.java, ClickData.CLICK_TYPE)
        .withSubtype(OpenProductClickData::class.java, SnippetType.TextSnippet.name)

data class PhantomClickData(
    val clickData: ClickData?
) {
    companion object {
        fun create(clickData: ClickData?): PhantomClickData {
            return PhantomClickData(clickData = clickData)
        }
    }
}
