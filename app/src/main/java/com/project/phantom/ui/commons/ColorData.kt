package com.project.phantom.ui.commons

import androidx.compose.ui.graphics.Color
import com.project.phantom.theme.color.PhantomColor
import com.project.phantom.theme.color.resolve
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class ColorData(
    @Json(name = "name") internal var name: PhantomColor? = null
) : Serializable {

    fun setDefaults(
        defaultColor: PhantomColor? = null
    ) {
        this.name = name ?: defaultColor
    }
}

fun ColorData?.getResolvedColor(defaultColor: PhantomColor? = null): Color {
    return (this?.name ?: defaultColor).resolve()
}
