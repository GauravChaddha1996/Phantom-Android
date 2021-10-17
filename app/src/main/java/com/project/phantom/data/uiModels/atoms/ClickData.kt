package com.project.phantom.data.uiModels.atoms

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ClickData(
    @Json(name = "type") val type: String? = null,
    @Json(name = "data") val data: Any? = null
)


@Stable
@Immutable
data class PhantomClickData(
    val type: String? = null,
    val data: Any? = null
) {
    companion object {

        fun create(clickData: ClickData?): PhantomClickData {
            return PhantomClickData(
                type = clickData?.type,
                data = clickData?.data
            )
        }
    }
}