package com.project.phantom.data.atoms

import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomFontStyle

class PhantomLceData(
    val showLoader: Boolean,
    val showError: Boolean,
    val errorMessage: PhantomTextData
) {
    companion object {

        fun getLoadingData() = PhantomLceData(
            showLoader = true,
            showError = false,
            errorMessage = PhantomTextData.create(null)
        )

        fun getContentData() = PhantomLceData(
            showLoader = false,
            showError = false,
            errorMessage = PhantomTextData.create(null)
        )

        fun getErrorData(errorMessage: String?) = PhantomLceData(
            showLoader = false,
            showError = true,
            errorMessage = PhantomTextData.create(
                TextData(
                    text = errorMessage,
                    color = ColorData(PhantomColorName.GREY_700),
                    font = FontData(PhantomFontStyle.MEDIUM_400)
                )
            )
        )
    }
}