package com.project.phantom.theme.color

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

@Suppress("MagicNumber")
object ColorScheme2 : PhantomColorScheme {
    override fun getName(): String = "Yellow"
    override fun getCode(): Int = 2

    override fun getLightScheme(): ColorScheme = lightColorScheme(
        primary = Color(0xFF7c5800),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFffdea0),
        onPrimaryContainer = Color(0xFF271900),
        secondary = Color(0xFF625B71),
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFFE8DEF8),
        onSecondaryContainer = Color(0xFF1D192B),
        tertiary = Color(0xFF7D5260),
        onTertiary = Color(0xFFFFFFFF),
        tertiaryContainer = Color(0xFFFFD8E4),
        onTertiaryContainer = Color(0xFF31111D),
        error = Color(0xFFB3261E),
        errorContainer = Color(0xFFF9DEDC),
        onError = Color(0xFFFFFFFF),
        onErrorContainer = Color(0xFF410E0B),
        background = Color(0xFFFFFBFE),
        onBackground = Color(0xFF1C1B1F),
        surface = Color(0xFFFFFBFE),
        onSurface = Color(0xFF1C1B1F),
        surfaceVariant = Color(0xFFE7E0EC),
        onSurfaceVariant = Color(0xFF49454F),
        outline = Color(0xFF8a938c),
        inverseOnSurface = Color(0xFFF4EFF4),
        inverseSurface = Color(0xFF313033)
    )

    override fun getDarkScheme(): ColorScheme = darkColorScheme(
        primary = Color(0xFFf7bd43),
        onPrimary = Color(0xFF422d00),
        primaryContainer = Color(0xFF5e4200),
        onPrimaryContainer = Color(0xFFffdea0),
        secondary = Color(0xFFCCC2DC),
        onSecondary = Color(0xFF332D41),
        secondaryContainer = Color(0xFF4A4458),
        onSecondaryContainer = Color(0xFFE8DEF8),
        tertiary = Color(0xFFEFB8C8),
        onTertiary = Color(0xFF492532),
        tertiaryContainer = Color(0xFF633B48),
        onTertiaryContainer = Color(0xFFFFD8E4),
        error = Color(0xFFF2B8B5),
        errorContainer = Color(0xFF8C1D18),
        onError = Color(0xFF601410),
        onErrorContainer = Color(0xFFF9DEDC),
        background = Color(0xFF1C1B1F),
        onBackground = Color(0xFFE6E1E5),
        surface = Color(0xFF323036),
        onSurface = Color(0xFFE6E1E5),
        surfaceVariant = Color(0xFF49454F),
        onSurfaceVariant = Color(0xFFCAC4D0),
        outline = Color(0xFFf7bd43),
        inverseOnSurface = Color(0xFF1C1B1F),
        inverseSurface = Color(0xFFE6E1E5)
    )
}
