package com.project.phantom.data.uiModels.network

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

data class ButtonData(
    val text: TextData? = null,
    val type: PhantomButtonType? = null,
    val clickData: ClickData? = null
)

@Stable
@Immutable
enum class PhantomButtonType {
    TEXT
}