package com.project.phantom.data.uiModels.atoms

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import com.project.phantom.data.uiModels.network.FontData
import com.project.phantom.theme.PhantomTypography

@Stable
@Immutable
class PhantomFontData private constructor(
    val resolvedTextStyle: TextStyle
) {
    companion object {
        fun create(data: FontData?): PhantomFontData {
            return PhantomFontData(
                resolvedTextStyle = PhantomTypography.resolve(data?.style)
            )
        }
    }
}