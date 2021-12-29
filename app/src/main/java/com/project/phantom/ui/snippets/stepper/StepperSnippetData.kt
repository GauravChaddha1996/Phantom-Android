package com.project.phantom.ui.snippets.stepper

import com.project.phantom.ui.snippets.commons.SnippetData
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class StepperSnippetData : SnippetData() {
    override fun setDefaults() {
        // no-op
    }
}
