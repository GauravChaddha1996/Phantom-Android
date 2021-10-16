package com.project.phantom.data.uiModels.atoms

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.project.phantom.data.uiModels.network.ImageData


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