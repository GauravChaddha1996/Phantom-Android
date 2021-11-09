package com.project.phantom.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun PhantomTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = phantomColor(),
        shapes = phantomShapes(),
        typography = phantomTypography()
    ) {
        content()
    }
}