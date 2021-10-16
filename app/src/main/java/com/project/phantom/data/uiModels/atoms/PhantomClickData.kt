package com.project.phantom.data.uiModels.atoms

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.project.phantom.data.uiModels.network.ClickData

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