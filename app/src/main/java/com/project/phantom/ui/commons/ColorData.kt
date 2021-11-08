package com.project.phantom.ui.commons

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomColors
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ColorData(
    @Json(name = "name") val name: PhantomColorName? = null
)

@Stable
@Immutable
class PhantomColorData private constructor(
    val resolvedColor: Color
) {
    companion object {

        fun create(
            data: ColorData?,
            defaultColorName: PhantomColorName? = null
        ): PhantomColorData {
            return PhantomColorData(
                resolvedColor = PhantomColors.resolve(data?.name ?: defaultColorName)
            )
        }
    }
}