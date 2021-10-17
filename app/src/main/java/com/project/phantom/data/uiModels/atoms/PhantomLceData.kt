package com.project.phantom.data.uiModels.atoms

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
            errorMessage = PhantomTextData.create(TextData(errorMessage))
        )
    }
}