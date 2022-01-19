package com.project.phantom.ui.commons

import androidx.compose.ui.text.TextStyle
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.theme.resolve
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FontData(
    @Json(name = "style") val style: PhantomFontStyle? = null
) {
    @Json(name = "defaultStyle")
    var defaultFontStyle: PhantomFontStyle? = null

    fun setDefaults(defaultFontStyle: PhantomFontStyle?) {
        this.defaultFontStyle = defaultFontStyle
    }

    fun resolve(): TextStyle? {
        return style?.resolve() ?: defaultFontStyle?.resolve()
    }
}
