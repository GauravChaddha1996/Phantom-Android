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

@Stable
@Immutable
enum class PhantomFontStyle {
    H1,
    H2,
    H3,
    H4,
    H5,
    H6,
    SUBTITLE1,
    SUBTITLE2,
    BODY1,
    BODY2,
    BUTTON,
    CAPTION,
    OVERLINE,
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
