package com.project.phantom.ui.text

import com.project.phantom.theme.PhantomFontStyle
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory

@JsonClass(generateAdapter = true)
data class MarkdownConfig(
    @Json(name = "enabled") val enabled: Boolean? = null,
    @Json(name = "spans") val spans: List<BaseMarkdownSpan>? = null
)

open class BaseMarkdownSpan {

    companion object {
        const val MK_SPAN_TYPE = "type"
        const val FONT_SPAN = "font"
    }

    @Json(name = MK_SPAN_TYPE)
    val type: String? = null
}

@JsonClass(generateAdapter = true)
class MarkdownFontSpan(
    @Json(name = "style") val style: PhantomFontStyle,
    @Json(name = "start") val start: Int,
    @Json(name = "end") val end: Int
) : BaseMarkdownSpan()

val MarkdownSpanPolymorphicJsonAdapter: PolymorphicJsonAdapterFactory<BaseMarkdownSpan> =
    PolymorphicJsonAdapterFactory.of(BaseMarkdownSpan::class.java, BaseMarkdownSpan.MK_SPAN_TYPE)
        .withSubtype(MarkdownFontSpan::class.java, BaseMarkdownSpan.FONT_SPAN)