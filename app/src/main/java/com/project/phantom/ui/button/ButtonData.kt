package com.project.phantom.ui.button

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.project.phantom.ui.click.ClickData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ButtonData(
    @Json(name = "text") val text: TextData? = null,
    @Json(name = "type") val type: PhantomButtonType? = null,
    @Json(name = "click") val clickData: ClickData? = null
)

@Stable
@Immutable
enum class PhantomButtonType {
    @Json(name = "text")
    TEXT
}
