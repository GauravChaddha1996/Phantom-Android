package com.project.phantom.ui.lce

import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomColorName.GREY_700
import com.project.phantom.theme.PhantomColorName.GREY_800
import com.project.phantom.theme.PhantomColorName.RED_300
import com.project.phantom.theme.PhantomFontStyle.MEDIUM_600
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_800
import com.project.phantom.ui.commons.ColorData
import com.project.phantom.ui.commons.FontData
import com.project.phantom.ui.text.TextData

data class PhantomLceData(
    val showLoader: Boolean,
    val showError: Boolean,
    val showSuccess: Boolean,
    val showNoResult: Boolean,
    val noResultMessage: TextData,
    val errorMessage: TextData,
    val phantomGhostColor: PhantomColorName
) {

    companion object {
        fun getLoadingData() = PhantomLceData(
            showLoader = true,
            showError = false,
            showSuccess = false,
            showNoResult = false,
            noResultMessage = TextData(),
            errorMessage = TextData(),
            phantomGhostColor = RED_300
        )

        fun getContentData() = PhantomLceData(
            showLoader = false,
            showError = false,
            showSuccess = true,
            showNoResult = false,
            noResultMessage = TextData(),
            errorMessage = TextData(),
            phantomGhostColor = RED_300
        )

        fun getErrorData(errorMessage: String?) = PhantomLceData(
            showLoader = false,
            showError = true,
            showSuccess = false,
            showNoResult = false,
            noResultMessage = TextData(),
            errorMessage = TextData(
                text = errorMessage,
                color = ColorData(GREY_700),
                font = FontData(MEDIUM_600)
            ),
            phantomGhostColor = RED_300
        )

        fun getEmptyResultData(emptyResultMessage: String?) = PhantomLceData(
            showLoader = false,
            showError = false,
            showSuccess = false,
            showNoResult = true,
            noResultMessage = TextData(
                text = emptyResultMessage,
                color = ColorData(GREY_800),
                font = FontData(SEMIBOLD_800)
            ),
            errorMessage = TextData(),
            phantomGhostColor = RED_300
        )
    }
}
