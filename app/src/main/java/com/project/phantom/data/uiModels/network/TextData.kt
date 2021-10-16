package com.project.phantom.data.uiModels.network

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

data class TextData(
    val text: String? = null,
    val color: ColorData? = null,
    val font: FontData? = null,
    val markdownConfig: MarkdownConfig? = null
)

@Stable
@Immutable
data class MarkdownConfig(
    val enabled: Boolean? = null
)