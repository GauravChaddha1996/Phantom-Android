package com.project.phantom.theme

import androidx.compose.material.lightColors
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.project.phantom.theme.PhantomColorName.*
import com.squareup.moshi.Json

@Stable
@Immutable
enum class PhantomColorName {
    @Json(name = "blue_700")
    BLUE_700,

    @Json(name = "red_500")
    RED_500,

    @Json(name = "grey_700")
    GREY_700
}

object PhantomColors {

    private val colorNameToColorMap = mapOf(
        BLUE_700 to Color.Blue,
        RED_500 to Color.Red,
        GREY_700 to Color.DarkGray
    )

    fun resolve(colorName: PhantomColorName?): Color {
        return colorNameToColorMap[colorName] ?: Color.Unspecified
    }
}

fun phantomColor() = lightColors(
    background = Color.Yellow
)
