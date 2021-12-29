package com.project.phantom.ui.lce

import com.project.phantom.PhantomApplication
import com.project.phantom.R
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.ui.commons.ColorData
import com.project.phantom.ui.commons.FontData
import com.project.phantom.ui.text.PhantomTextData
import com.project.phantom.ui.text.TextData

class PhantomLceData(
    val showLoader: Boolean,
    val showError: Boolean,
    val errorMessage: PhantomTextData
) {
    private val retryText = PhantomApplication.INSTANCE.getString(R.string.retry)
    var retryTextData = TextData(
        text = retryText,
        font = FontData(PhantomFontStyle.SEMIBOLD_600),
        color = ColorData(PhantomColorName.RED_500)
    )

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
                    font = FontData(PhantomFontStyle.MEDIUM_600)
                )
            )
        )
    }
}
