package com.project.phantom.ui.lce

import com.project.phantom.theme.color.PhantomColor
import com.project.phantom.theme.font.PhantomTextStyle
import com.project.phantom.ui.commons.ColorData
import com.project.phantom.ui.commons.FontData
import com.project.phantom.ui.text.TextData

data class PhantomLceData(
    val showLoader: Boolean,
    val showError: Boolean,
    val showSuccess: Boolean,
    val showNoResult: Boolean,
    val noResultMessage: TextData,
    val errorMessage: TextData
) {
    fun isSuccessOrNoResultState() = showSuccess || showNoResult

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
                color = ColorData(PhantomColor.OnBackground),
                font = FontData(PhantomTextStyle.TitleSemiLarge)
            )
        )

        fun getEmptyResultData(emptyResultMessage: String?) = PhantomLceData(
            showLoader = false,
            showError = false,
            showSuccess = false,
            showNoResult = true,
            noResultMessage = TextData(
                text = emptyResultMessage,
                color = ColorData(PhantomColor.OnBackground),
                font = FontData(PhantomTextStyle.TitleSemiLarge)
            ),
            errorMessage = TextData()
        )
    }
}
