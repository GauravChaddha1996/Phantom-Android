package com.project.phantom.ui.commons

import androidx.compose.ui.graphics.Color
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomColors
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class ColorData(
    @Json(name = "name") var name: PhantomColorName? = null
) : Serializable {

    fun setDefaults(
        defaultColorName: PhantomColorName? = null
    ) {
        this.name = name ?: defaultColorName
    }
}

fun ColorData?.getResolvedColor(defaultColorName: PhantomColorName? = null): Color {
    return PhantomColors.resolve(this?.name ?: defaultColorName)
}
