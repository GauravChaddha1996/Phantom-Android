package com.project.phantom.ui.lce

import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.ui.commons.ColorData
import com.project.phantom.ui.commons.FontData
import com.project.phantom.ui.text.TextData

class PhantomLceData(
    val showLoader: Boolean,
    val showError: Boolean,
    val showSuccess: Boolean,
    val errorMessage: TextData
) {

    companion object {
        fun getLoadingData() = PhantomLceData(
            showLoader = true,
            showError = false,
            showSuccess = false,
            errorMessage = TextData()
        )

        fun getContentData() = PhantomLceData(
            showLoader = false,
            showError = false,
            showSuccess = true,
            errorMessage = TextData()
        )

        fun getErrorData(errorMessage: String?) = PhantomLceData(
            showLoader = false,
            showError = true,
            showSuccess = false,
            errorMessage = TextData(
                text = errorMessage,
                color = ColorData(PhantomColorName.GREY_700),
                font = FontData(PhantomFontStyle.MEDIUM_600)
            )
        )
    }
}
