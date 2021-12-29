package com.project.phantom.ui.snippets.textSection

import com.project.phantom.ui.snippets.commons.SnippetData
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class TextSectionSnippetData : SnippetData() {
    override fun setDefaults() {
        // no-op
    }
}
