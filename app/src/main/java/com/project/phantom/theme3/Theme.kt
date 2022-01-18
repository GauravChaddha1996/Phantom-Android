package com.project.phantom.theme3

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable


@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkThemeColors,
        typography = AppTypography,
        content = content
    )
}