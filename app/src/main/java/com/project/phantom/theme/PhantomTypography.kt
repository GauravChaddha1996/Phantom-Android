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
import com.project.phantom.theme.PhantomFontStyle.LIGHT_100
import com.project.phantom.theme.PhantomFontStyle.LIGHT_200
import com.project.phantom.theme.PhantomFontStyle.LIGHT_300
import com.project.phantom.theme.PhantomFontStyle.LIGHT_400
import com.project.phantom.theme.PhantomFontStyle.LIGHT_500
import com.project.phantom.theme.PhantomFontStyle.LIGHT_600
import com.project.phantom.theme.PhantomFontStyle.LIGHT_700
import com.project.phantom.theme.PhantomFontStyle.LIGHT_800
import com.project.phantom.theme.PhantomFontStyle.LIGHT_900
import com.project.phantom.theme.PhantomFontStyle.MEDIUM_100
import com.project.phantom.theme.PhantomFontStyle.MEDIUM_200
import com.project.phantom.theme.PhantomFontStyle.MEDIUM_300
import com.project.phantom.theme.PhantomFontStyle.MEDIUM_400
import com.project.phantom.theme.PhantomFontStyle.MEDIUM_500
import com.project.phantom.theme.PhantomFontStyle.MEDIUM_600
import com.project.phantom.theme.PhantomFontStyle.MEDIUM_700
import com.project.phantom.theme.PhantomFontStyle.MEDIUM_800
import com.project.phantom.theme.PhantomFontStyle.MEDIUM_900
import com.project.phantom.theme.PhantomFontStyle.REGULAR_100
import com.project.phantom.theme.PhantomFontStyle.REGULAR_200
import com.project.phantom.theme.PhantomFontStyle.REGULAR_300
import com.project.phantom.theme.PhantomFontStyle.REGULAR_400
import com.project.phantom.theme.PhantomFontStyle.REGULAR_500
import com.project.phantom.theme.PhantomFontStyle.REGULAR_600
import com.project.phantom.theme.PhantomFontStyle.REGULAR_700
import com.project.phantom.theme.PhantomFontStyle.REGULAR_800
import com.project.phantom.theme.PhantomFontStyle.REGULAR_900
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_100
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_200
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_300
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_400
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_500
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_600
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_700
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_800
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_900
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_940
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_950
import com.project.phantom.theme.PhantomTypography.RalewayFontFamily

object PhantomTypography {
    private val FontLight = Font(R.font.raleway_light, Light, FontStyle.Normal)
    private val FontRegular = Font(R.font.raleway_regular, Normal, FontStyle.Normal)
    private val FontMedium = Font(R.font.raleway_medium, Medium, FontStyle.Normal)
    private val FontSemibold = Font(R.font.raleway_semibold, SemiBold, FontStyle.Normal)
    val RalewayFontFamily = FontFamily(FontLight, FontRegular, FontMedium, FontSemibold)

    fun resolve(fontStyle: PhantomFontStyle?): TextStyle {
        return resolveLightFontStyle(fontStyle)
            ?: resolveRegularFontStyle(fontStyle)
            ?: resolveMediumFontStyle(fontStyle)
            ?: resolveSemiboldFontStyle(fontStyle)
            ?: resolve(REGULAR_300)
    }

    private fun resolveLightFontStyle(fontStyle: PhantomFontStyle?): TextStyle? {
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
            else -> null
        }
    }

    private fun resolveRegularFontStyle(fontStyle: PhantomFontStyle?): TextStyle? {
        return when (fontStyle) {
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
            else -> null
        }
    }

    private fun resolveMediumFontStyle(fontStyle: PhantomFontStyle?): TextStyle? {
        return when (fontStyle) {
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
            else -> null
        }
    }

    private fun resolveSemiboldFontStyle(fontStyle: PhantomFontStyle?): TextStyle? {
        return when (fontStyle) {
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
            SEMIBOLD_940 -> TextStyle(
                fontWeight = SemiBold,
                fontSize = 56.sp,
                fontFamily = RalewayFontFamily
            )
            SEMIBOLD_950 -> TextStyle(
                fontWeight = SemiBold,
                fontSize = 192.sp,
                fontFamily = RalewayFontFamily
            )
            else -> null
        }
    }
}

fun phantomTypography() = Typography(
    defaultFontFamily = RalewayFontFamily
)
