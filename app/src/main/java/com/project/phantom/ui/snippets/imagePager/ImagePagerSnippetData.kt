package com.project.phantom.ui.snippets.imagePager

import com.project.phantom.ui.snippets.commons.SnippetData
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ImagePagerSnippetData : SnippetData() {
    override fun setDefaults() {
        // no-op
    }
}
