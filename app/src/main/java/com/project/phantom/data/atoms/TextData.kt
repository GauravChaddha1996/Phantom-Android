package com.project.phantom.data.atoms

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TextData(
    @Json(name = "text") val text: String? = null,
    @Json(name = "color") val color: ColorData? = null,
    @Json(name = "font") val font: FontData? = null,
    @Json(name = "markdown_config") val markdownConfig: MarkdownConfig? = null
)

@Stable
@Immutable
@JsonClass(generateAdapter = true)
data class MarkdownConfig(
    @Json(name = "enabled") val enabled: Boolean? = null
)

@Stable
@Immutable
class PhantomTextData private constructor(
    val text: String,
    val color: PhantomColorData,
    val font: PhantomFontData,
    val markdownConfig: MarkdownConfig? = null
) {
    companion object {
        fun create(data: TextData?): PhantomTextData {
            return PhantomTextData(
                text = data?.text ?: "",
                color = PhantomColorData.create(data?.color),
                font = PhantomFontData.create(data?.font),
                markdownConfig = data?.markdownConfig
            )
        }
    }
}