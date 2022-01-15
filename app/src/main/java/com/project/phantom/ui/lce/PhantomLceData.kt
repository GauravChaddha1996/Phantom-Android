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
    val showNoResult: Boolean,
    val noResultMessage: TextData,
    val errorMessage: TextData
) {

    companion object {
        fun getLoadingData() = PhantomLceData(
            showLoader = true,
            showError = false,
            showSuccess = false,
            showNoResult = false,
            noResultMessage = TextData(),
            errorMessage = TextData()
        )

        fun getContentData() = PhantomLceData(
            showLoader = false,
            showError = false,
            showSuccess = true,
            showNoResult = false,
            noResultMessage = TextData(),
            errorMessage = TextData()
        )

        fun getErrorData(errorMessage: String?) = PhantomLceData(
            showLoader = false,
            showError = true,
            showSuccess = false,
            showNoResult = false,
            noResultMessage = TextData(),
            errorMessage = TextData(
                text = errorMessage,
                color = ColorData(PhantomColorName.GREY_700),
                font = FontData(PhantomFontStyle.MEDIUM_600)
            )
        )

        fun getEmptyResultData(emptyResultMessage: String?) = PhantomLceData(
            showLoader = false,
            showError = false,
            showSuccess = false,
            showNoResult = true,
            noResultMessage = TextData(
                text = emptyResultMessage,
                color = ColorData(PhantomColorName.GREY_800),
                font = FontData(PhantomFontStyle.SEMIBOLD_800)
            ),
            errorMessage = TextData()
        )
    }
}
