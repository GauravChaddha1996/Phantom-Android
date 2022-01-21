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
        defaultMinLines: Int = 0,
        defaultMaxLines: Int = Int.MAX_VALUE,
        overflow: TextOverflow = TextOverflow.Ellipsis
    ): TextData {
        this.text = this.text?.takeIf { it.isNotEmpty() } ?: text
        this.font = (this.font ?: FontData()).setDefaults(textStyle)
        this.color = (this.color ?: ColorData()).setDefaults(color)
        this.minLines = minLines ?: defaultMinLines
        this.maxLines = maxLines ?: defaultMaxLines
        this.overflow = overflow
        return this
    }
}
