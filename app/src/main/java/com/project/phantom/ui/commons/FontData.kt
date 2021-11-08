package com.project.phantom.ui.commons

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.theme.PhantomTypography
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FontData(
    @Json(name = "style") val style: PhantomFontStyle? = null
)

@Stable
@Immutable
class PhantomFontData private constructor(
    val resolvedTextStyle: TextStyle
) {
    companion object {
        fun create(
            data: FontData?,
            defaultFontStyle: PhantomFontStyle? = null
        ): PhantomFontData {
            return PhantomFontData(
                resolvedTextStyle = PhantomTypography.resolve(data?.style ?: defaultFontStyle)
            )
        }
    }
}