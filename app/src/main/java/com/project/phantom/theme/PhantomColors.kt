package com.project.phantom.theme

import androidx.compose.material.lightColors
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.project.phantom.theme.PhantomColorName.BLUE_700

@Stable
@Immutable
enum class PhantomColorName {
    BLUE_700
}

object PhantomColors {

    private val colorNameToColorMap = mapOf(
        BLUE_700 to Color.Blue
    )

    fun resolve(colorName: PhantomColorName?): Color {
        return colorNameToColorMap[colorName] ?: Color.Unspecified
    }
}

fun phantomColor() = lightColors(
    background = Color.Yellow
)
