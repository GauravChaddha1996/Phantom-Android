package com.project.phantom.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun PhantomTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = phantomColor(),
        typography = phantomTypography()
    ) {
        content()
    }
}
