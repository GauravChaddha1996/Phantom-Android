package com.project.phantom.data.uiModels.atoms

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ButtonData(
    @Json(name = "text") val text: TextData? = null,
    @Json(name = "type") val type: PhantomButtonType? = null,
    @Json(name = "click_data") val clickData: ClickData? = null
)

@Stable
@Immutable
enum class PhantomButtonType {
    @Json(name = "text")
    TEXT
}

@Stable
@Immutable
class PhantomButtonData private constructor(
    val text: PhantomTextData,
    val type: PhantomButtonType,
    val clickData: PhantomClickData
) {
    companion object {
        fun create(data: ButtonData?): PhantomButtonData {
            return PhantomButtonData(
                PhantomTextData.create(data?.text),
                data?.type ?: PhantomButtonType.TEXT,
                PhantomClickData.create(data?.clickData)
            )
        }
    }
}