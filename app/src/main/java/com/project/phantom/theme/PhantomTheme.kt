package com.project.phantom.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.dp

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

object AppTheme {
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colors

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.shapes

    val ElevationStyle = ElevationStyle()
    val PaddingStyle = PaddingStyle()
    val CornerShape = Shapes(
        RoundedCornerShape(4.dp),
        RoundedCornerShape(8.dp),
        RoundedCornerShape(12.dp)
    )


}