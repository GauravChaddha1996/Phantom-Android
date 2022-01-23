package com.project.phantom.ui.commons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.project.phantom.theme.color.PhantomColor
import com.project.phantom.theme.color.resolve
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ColorData(
    @Json(name = "name") internal var name: PhantomColor? = null
) {

    fun setDefaults(
        defaultColor: PhantomColor? = null
    ): ColorData {
        this.name = name ?: defaultColor
        return this
    }
}

@Composable
fun ColorData?.getResolvedColor(defaultColor: PhantomColor? = null): Color {
    return (this?.name ?: defaultColor).resolve()
}
