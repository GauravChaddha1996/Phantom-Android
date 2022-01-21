package com.project.phantom.ui.commons

import androidx.compose.ui.text.TextStyle
import com.project.phantom.theme.font.PhantomTextStyle
import com.project.phantom.theme.font.resolve
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FontData(
    @Json(name = "style") val style: PhantomTextStyle? = null
) {
    @Json(name = "defaultStyle")
    var defaultTextStyle: PhantomTextStyle? = null

    fun setDefaults(defaultTextStyle: PhantomTextStyle?) {
        this.defaultTextStyle = defaultTextStyle
    }

    fun resolve(): TextStyle? {
        return style?.resolve() ?: defaultTextStyle?.resolve()
    }
}
