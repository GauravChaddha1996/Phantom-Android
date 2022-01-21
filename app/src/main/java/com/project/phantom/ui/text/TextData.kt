package com.project.phantom.ui.text

import androidx.compose.ui.text.style.TextOverflow
import com.project.phantom.theme.color.PhantomColor
import com.project.phantom.theme.font.PhantomTextStyle
import com.project.phantom.ui.commons.ColorData
import com.project.phantom.ui.commons.FontData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TextData(
    @Json(name = "text") var text: String? = null,
    @Json(name = "font") val font: FontData = FontData(),
    @Json(name = "color") val color: ColorData = ColorData(),
    @Json(name = "min_lines") var minLines: Int? = null,
    @Json(name = "max_lines") var maxLines: Int? = null,
    @Json(name = "markdown_config") val markdownConfig: MarkdownConfig? = null
) {
    @Transient
    var overflow: TextOverflow = TextOverflow.Ellipsis

    fun setDefaults(
        defaultText: String? = null,
        textStyle: PhantomTextStyle? = null,
        color: PhantomColor? = null,
        defaultMinLines: Int = 0,
        defaultMaxLines: Int = Int.MAX_VALUE,
        overflow: TextOverflow = TextOverflow.Ellipsis
    ): TextData {
        text = text?.takeIf { it.isNotEmpty() } ?: defaultText
        font.setDefaults(textStyle)
        this.color.setDefaults(color)
        minLines = minLines ?: defaultMinLines
        maxLines = maxLines ?: defaultMaxLines
        this.overflow = overflow
        return this
    }
}
