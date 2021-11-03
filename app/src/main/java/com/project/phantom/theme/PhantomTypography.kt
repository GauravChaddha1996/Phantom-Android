package com.project.phantom.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.sp
import com.project.phantom.R
import com.project.phantom.theme.PhantomFontStyle.*
import com.project.phantom.theme.PhantomTypography.RalewayFontFamily

object PhantomTypography {
    private val FontLight = Font(R.font.raleway_light, Light, FontStyle.Normal)
    private val FontRegular = Font(R.font.raleway_regular, Normal, FontStyle.Normal)
    private val FontMedium = Font(R.font.raleway_medium, Medium, FontStyle.Normal)
    private val FontSemibold = Font(R.font.raleway_semibold, SemiBold, FontStyle.Normal)
    val RalewayFontFamily = FontFamily(FontLight, FontRegular, FontMedium, FontSemibold)

    fun resolve(fontStyle: PhantomFontStyle?): TextStyle {
        return when (fontStyle) {
            LIGHT_100 -> TextStyle(
                fontWeight = Light,
                fontSize = 10.sp,
                fontFamily = RalewayFontFamily
            )
            LIGHT_200 -> TextStyle(
                fontWeight = Light,
                fontSize = 12.sp,
                fontFamily = RalewayFontFamily
            )
            LIGHT_300 -> TextStyle(
                fontWeight = Light,
                fontSize = 13.sp,
                fontFamily = RalewayFontFamily
            )
            LIGHT_400 -> TextStyle(
                fontWeight = Light,
                fontSize = 15.sp,
                fontFamily = RalewayFontFamily
            )
            LIGHT_500 -> TextStyle(
                fontWeight = Light,
                fontSize = 17.sp,
                fontFamily = RalewayFontFamily
            )
            LIGHT_600 -> TextStyle(
                fontWeight = Light,
                fontSize = 18.sp,
                fontFamily = RalewayFontFamily
            )
            LIGHT_700 -> TextStyle(
                fontWeight = Light,
                fontSize = 20.sp,
                fontFamily = RalewayFontFamily
            )
            LIGHT_800 -> TextStyle(
                fontWeight = Light,
                fontSize = 24.sp,
                fontFamily = RalewayFontFamily
            )
            LIGHT_900 -> TextStyle(
                fontWeight = Light,
                fontSize = 32.sp,
                fontFamily = RalewayFontFamily
            )
            REGULAR_100 -> TextStyle(
                fontWeight = Normal,
                fontSize = 10.sp,
                fontFamily = RalewayFontFamily
            )
            REGULAR_200 -> TextStyle(
                fontWeight = Normal,
                fontSize = 12.sp,
                fontFamily = RalewayFontFamily
            )
            REGULAR_300 -> TextStyle(
                fontWeight = Normal,
                fontSize = 13.sp,
                fontFamily = RalewayFontFamily
            )
            REGULAR_400 -> TextStyle(
                fontWeight = Normal,
                fontSize = 15.sp,
                fontFamily = RalewayFontFamily
            )
            REGULAR_500 -> TextStyle(
                fontWeight = Normal,
                fontSize = 17.sp,
                fontFamily = RalewayFontFamily
            )
            REGULAR_600 -> TextStyle(
                fontWeight = Normal,
                fontSize = 18.sp,
                fontFamily = RalewayFontFamily
            )
            REGULAR_700 -> TextStyle(
                fontWeight = Normal,
                fontSize = 20.sp,
                fontFamily = RalewayFontFamily
            )
            REGULAR_800 -> TextStyle(
                fontWeight = Normal,
                fontSize = 24.sp,
                fontFamily = RalewayFontFamily
            )
            REGULAR_900 -> TextStyle(
                fontWeight = Normal,
                fontSize = 32.sp,
                fontFamily = RalewayFontFamily
            )
            MEDIUM_100 -> TextStyle(
                fontWeight = Medium,
                fontSize = 10.sp,
                fontFamily = RalewayFontFamily
            )
            MEDIUM_200 -> TextStyle(
                fontWeight = Medium,
                fontSize = 12.sp,
                fontFamily = RalewayFontFamily
            )
            MEDIUM_300 -> TextStyle(
                fontWeight = Medium,
                fontSize = 13.sp,
                fontFamily = RalewayFontFamily
            )
            MEDIUM_400 -> TextStyle(
                fontWeight = Medium,
                fontSize = 15.sp,
                fontFamily = RalewayFontFamily
            )
            MEDIUM_500 -> TextStyle(
                fontWeight = Medium,
                fontSize = 17.sp,
                fontFamily = RalewayFontFamily
            )
            MEDIUM_600 -> TextStyle(
                fontWeight = Medium,
                fontSize = 18.sp,
                fontFamily = RalewayFontFamily
            )
            MEDIUM_700 -> TextStyle(
                fontWeight = Medium,
                fontSize = 20.sp,
                fontFamily = RalewayFontFamily
            )
            MEDIUM_800 -> TextStyle(
                fontWeight = Medium,
                fontSize = 24.sp,
                fontFamily = RalewayFontFamily
            )
            MEDIUM_900 -> TextStyle(
                fontWeight = Medium,
                fontSize = 32.sp,
                fontFamily = RalewayFontFamily
            )
            SEMIBOLD_100 -> TextStyle(
                fontWeight = SemiBold,
                fontSize = 10.sp,
                fontFamily = RalewayFontFamily
            )
            SEMIBOLD_200 -> TextStyle(
                fontWeight = SemiBold,
                fontSize = 12.sp,
                fontFamily = RalewayFontFamily
            )
            SEMIBOLD_300 -> TextStyle(
                fontWeight = SemiBold,
                fontSize = 13.sp,
                fontFamily = RalewayFontFamily
            )
            SEMIBOLD_400 -> TextStyle(
                fontWeight = SemiBold,
                fontSize = 15.sp,
                fontFamily = RalewayFontFamily
            )
            SEMIBOLD_500 -> TextStyle(
                fontWeight = SemiBold,
                fontSize = 17.sp,
                fontFamily = RalewayFontFamily
            )
            SEMIBOLD_600 -> TextStyle(
                fontWeight = SemiBold,
                fontSize = 18.sp,
                fontFamily = RalewayFontFamily
            )
            SEMIBOLD_700 -> TextStyle(
                fontWeight = SemiBold,
                fontSize = 20.sp,
                fontFamily = RalewayFontFamily
            )
            SEMIBOLD_800 -> TextStyle(
                fontWeight = SemiBold,
                fontSize = 24.sp,
                fontFamily = RalewayFontFamily
            )
            SEMIBOLD_900 -> TextStyle(
                fontWeight = SemiBold,
                fontSize = 32.sp,
                fontFamily = RalewayFontFamily
            )
            null -> TextStyle(
                fontWeight = Normal,
                fontSize = 13.sp,
                fontFamily = RalewayFontFamily
            )
        }
    }
}

fun phantomTypography() = Typography(
    defaultFontFamily = RalewayFontFamily
)
