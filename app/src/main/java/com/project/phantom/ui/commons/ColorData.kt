package com.project.phantom.ui.commons

import androidx.compose.ui.graphics.Color
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomColors
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ColorData(
    @Json(name = "name") val name: PhantomColorName? = null
) {
    @Transient
    var resolvedColor = PhantomColors.resolve(name)

    fun setDefaults(
        defaultColorName: PhantomColorName? = null
    ) {
        resolvedColor = PhantomColors.resolve(name ?: defaultColorName)
    }
}

fun ColorData?.getResolvedColor(): Color {
    return this?.resolvedColor ?: Color.Unspecified
}
