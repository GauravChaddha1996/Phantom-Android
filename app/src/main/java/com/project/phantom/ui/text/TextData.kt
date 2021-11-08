package com.project.phantom.ui.text

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.ui.commons.ColorData
import com.project.phantom.ui.commons.FontData
import com.project.phantom.ui.commons.PhantomColorData
import com.project.phantom.ui.commons.PhantomFontData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TextData(
    @Json(name = "text") val text: String? = null,
    @Json(name = "color") val color: ColorData? = null,
    @Json(name = "font") val font: FontData? = null,
    @Json(name = "min_lines") val minLines: Int? = null,
    @Json(name = "max_lines") val maxLines: Int? = null,
    @Json(name = "markdown_config") val markdownConfig: MarkdownConfig? = null
)

@Stable
@Immutable
class PhantomTextData private constructor(
    val text: AnnotatedString,
    val color: PhantomColorData,
    val font: PhantomFontData,
    val maxLines: Int,
    val minLines: Int = 0,
    val overflow: TextOverflow
) {
    companion object {
        fun create(
            data: TextData?,
            fontStyle: PhantomFontStyle? = null,
            colorName: PhantomColorName? = null,
            minLines: Int = 0,
            maxLines: Int = Int.MAX_VALUE,
            overflow: TextOverflow? = null
        ): PhantomTextData {
            return PhantomTextData(
                text = MarkdownProcessor.processTextData(data),
                color = PhantomColorData.create(data?.color, colorName),
                font = PhantomFontData.create(data?.font, fontStyle),
                minLines = data?.minLines ?: minLines,
                maxLines = data?.maxLines ?: maxLines,
                overflow = overflow ?: TextOverflow.Ellipsis
            )
        }
    }
}