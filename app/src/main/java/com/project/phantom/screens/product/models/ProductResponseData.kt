package com.project.phantom.screens.product.models

import com.project.phantom.ui.snippets.commons.SnippetSectionData
import com.project.phantom.ui.snippets.stepper.StepperSnippetData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ProductResponseData(
    @Json(name = "status")
    val status: String? = null,

    @Json(name = "message")
    val message: String? = null,

    @Json(name = "snippets")
    val snippetSectionList: List<SnippetSectionData>? = null,

    @Json(name = "stepper_snippet")
    val stepperSnippetData: StepperSnippetData? = null
)
