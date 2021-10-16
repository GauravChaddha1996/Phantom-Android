package com.project.phantom.data.uiModels.atoms

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.project.phantom.data.uiModels.network.ColorData
import com.project.phantom.theme.PhantomColors

@Stable
@Immutable
class PhantomColorData private constructor(
    val resolvedColor: Color
) {
    companion object {

        fun create(data: ColorData?): PhantomColorData {
            return PhantomColorData(
                resolvedColor = PhantomColors.resolve(data?.name)
            )
        }
    }
}