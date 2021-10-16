package com.project.phantom.data.uiModels.atoms

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.project.phantom.data.uiModels.network.ButtonData
import com.project.phantom.data.uiModels.network.PhantomButtonType

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