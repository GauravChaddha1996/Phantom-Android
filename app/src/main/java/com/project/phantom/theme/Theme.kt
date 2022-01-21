package com.project.phantom.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.project.phantom.theme.color.DarkThemeColors
import com.project.phantom.theme.color.LightThemeColors
import com.project.phantom.theme.font.AppTypography

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
