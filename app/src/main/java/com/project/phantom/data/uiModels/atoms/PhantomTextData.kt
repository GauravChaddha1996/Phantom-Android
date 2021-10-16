package com.project.phantom.data.uiModels.atoms

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.project.phantom.data.uiModels.network.MarkdownConfig
import com.project.phantom.data.uiModels.network.TextData

@Stable
@Immutable
class PhantomTextData private constructor(
    val text: String,
    val color: PhantomColorData,
    val font: PhantomFontData,
    val markdownConfig: MarkdownConfig? = null
) {
    companion object {
        fun create(data: TextData?): PhantomTextData {
            return PhantomTextData(
                text = data?.text ?: "",
                color = PhantomColorData.create(data?.color),
                font = PhantomFontData.create(data?.font),
                markdownConfig = data?.markdownConfig
            )
        }
    }
}