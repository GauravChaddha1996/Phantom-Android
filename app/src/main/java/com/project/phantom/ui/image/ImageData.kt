package com.project.phantom.ui.image

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageData(
    @Json(name = "url") val url: String? = null
)

@Stable
@Immutable
class PhantomImageData private constructor(
    val url: String
) {
    companion object {

        private const val DefaultPlaceholder: String = ""

        fun create(data: ImageData?): PhantomImageData {
            return PhantomImageData(
                url = data?.url ?: DefaultPlaceholder
            )
        }
    }
}
