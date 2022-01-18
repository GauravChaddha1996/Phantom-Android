package com.project.phantom.theme3

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

var AppThemeColors = LightThemeColors

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val darkMode = isSystemInDarkTheme()
    AppThemeColors = if (darkMode) DarkThemeColors else LightThemeColors
    MaterialTheme(
        colorScheme = AppThemeColors,
        typography = AppTypography,
        content = content
    )
}
