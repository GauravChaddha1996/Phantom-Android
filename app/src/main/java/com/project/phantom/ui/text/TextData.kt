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
    @Json(name = "font") var font: FontData? = null,
    @Json(name = "color") var color: ColorData? = null,
    @Json(name = "min_lines") var minLines: Int? = null,
    @Json(name = "max_lines") var maxLines: Int? = null,
    @Json(name = "markdown_config") val markdownConfig: MarkdownConfig? = null
) {
    @Transient
    var overflow: TextOverflow = TextOverflow.Ellipsis

    fun setDefaults(
        text: String? = null,
        textStyle: PhantomTextStyle? = null,
        color: PhantomColor? = null,
        defaultMinLines: Int? = null,
        defaultMaxLines: Int? = null,
        overflow: TextOverflow = TextOverflow.Ellipsis
    ): TextData {
        text?.takeIf { it.isNotEmpty() }?.let {
            this.text = this.text?.takeIf { it.isNotEmpty() } ?: text
        }
        textStyle?.let {
            this.font = (this.font ?: FontData()).setDefaults(textStyle)
        }
        color?.let {
            this.color = (this.color ?: ColorData()).setDefaults(color)
        }
        defaultMinLines?.let {
            this.minLines = minLines ?: defaultMinLines
        }
        defaultMaxLines?.let {
            this.maxLines = maxLines ?: defaultMaxLines
        }
        this.overflow = overflow
        return this
    }
}
