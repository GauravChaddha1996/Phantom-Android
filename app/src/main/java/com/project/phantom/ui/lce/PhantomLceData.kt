package com.project.phantom.ui.lce

import androidx.compose.ui.graphics.Color
import com.project.phantom.theme.PhantomColorName.OnBackground
import com.project.phantom.theme.PhantomFontStyle.LabelLarge
import com.project.phantom.theme3.AppThemeColors
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
    val phantomGhostColor: Color
) {

    companion object {
        fun getLoadingData() = PhantomLceData(
            showLoader = true,
            showError = false,
            showSuccess = false,
            showNoResult = false,
            noResultMessage = TextData(),
            errorMessage = TextData(),
            phantomGhostColor = AppThemeColors.primary
        )

        fun getContentData() = PhantomLceData(
            showLoader = false,
            showError = false,
            showSuccess = true,
            showNoResult = false,
            noResultMessage = TextData(),
            errorMessage = TextData(),
            phantomGhostColor = AppThemeColors.primary
        )

        fun getErrorData(errorMessage: String?) = PhantomLceData(
            showLoader = false,
            showError = true,
            showSuccess = false,
            showNoResult = false,
            noResultMessage = TextData(),
            errorMessage = TextData(
                text = errorMessage,
                color = ColorData(OnBackground),
                font = FontData(LabelLarge)
            ),
            phantomGhostColor = AppThemeColors.primary
        )

        fun getEmptyResultData(emptyResultMessage: String?) = PhantomLceData(
            showLoader = false,
            showError = false,
            showSuccess = false,
            showNoResult = true,
            noResultMessage = TextData(
                text = emptyResultMessage,
                color = ColorData(OnBackground),
                font = FontData(LabelLarge)
            ),
            errorMessage = TextData(),
            phantomGhostColor = AppThemeColors.primary
        )
    }
}
