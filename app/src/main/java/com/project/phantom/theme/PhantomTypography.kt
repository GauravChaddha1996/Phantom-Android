package com.project.phantom.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import com.project.phantom.R
import com.squareup.moshi.Json

@Stable
@Immutable
enum class PhantomFontStyle {
    @Json(name = "h1")
    H1,

    @Json(name = "h2")
    H2,

    @Json(name = "h3")
    H3,

    @Json(name = "h4")
    H4,

    @Json(name = "h5")
    H5,

    @Json(name = "h6")
    H6,

    @Json(name = "subtitle1")
    SUBTITLE1,

    @Json(name = "subtitle2")
    SUBTITLE2,

    @Json(name = "body1")
    BODY1,

    @Json(name = "body2")
    BODY2,

    @Json(name = "button")
    BUTTON,

    @Json(name = "caption")
    CAPTION,

    @Json(name = "overline")
    OVERLINE
}

object PhantomTypography {
    val FontLight = Font(R.font.raleway_light, Light, FontStyle.Normal)
    val FontRegular = Font(R.font.raleway_regular, Normal, FontStyle.Normal)
    val FontMedium = Font(R.font.raleway_medium, Medium, FontStyle.Normal)
    val FontSemibold = Font(R.font.raleway_semibold, SemiBold, FontStyle.Normal)

    fun resolve(fontStyle: PhantomFontStyle?): TextStyle {
        return with(phantomTypography()) {
            when (fontStyle) {
                PhantomFontStyle.H1 -> h1
                PhantomFontStyle.H2 -> h2
                PhantomFontStyle.H3 -> h3
                PhantomFontStyle.H4 -> h4
                PhantomFontStyle.H5 -> h5
                PhantomFontStyle.H6 -> h6
                PhantomFontStyle.SUBTITLE1 -> subtitle1
                PhantomFontStyle.SUBTITLE2 -> subtitle2
                PhantomFontStyle.BODY1 -> body1
                PhantomFontStyle.BODY2 -> body2
                PhantomFontStyle.BUTTON -> button
                PhantomFontStyle.CAPTION -> caption
                PhantomFontStyle.OVERLINE -> overline
                null -> body1
            }
        }
    }
}

fun phantomTypography() = Typography(
    defaultFontFamily = FontFamily(
        PhantomTypography.FontLight,
        PhantomTypography.FontRegular,
        PhantomTypography.FontMedium,
        PhantomTypography.FontSemibold
    )
)
