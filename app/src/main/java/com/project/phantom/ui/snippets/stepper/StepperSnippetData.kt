package com.project.phantom.ui.snippets.stepper

import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class StepperSnippetData(
    @Json(name = "title") val title: TextData? = null
) : SnippetData() {
    override fun setDefaults() {
        // no-op
    }
}
