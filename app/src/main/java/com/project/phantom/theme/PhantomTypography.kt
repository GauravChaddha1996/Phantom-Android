package com.project.phantom.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import com.project.phantom.R

fun phantomTypography() = Typography(
    defaultFontFamily = FontFamily(
        PhantomTypography.FontLight,
        PhantomTypography.FontRegular,
        PhantomTypography.FontMedium,
        PhantomTypography.FontSemibold
    )
)

object PhantomTypography {
    val FontLight = Font(R.font.raleway_light, Light, FontStyle.Normal)
    val FontRegular = Font(R.font.raleway_regular, Normal, FontStyle.Normal)
    val FontMedium = Font(R.font.raleway_medium, Medium, FontStyle.Normal)
    val FontSemibold = Font(R.font.raleway_semibold, SemiBold, FontStyle.Normal)
}