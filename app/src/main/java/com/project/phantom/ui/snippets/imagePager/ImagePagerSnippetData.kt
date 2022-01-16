package com.project.phantom.ui.snippets.imagePager

import com.project.phantom.ui.image.ImageData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ImagePagerSnippetData(
    @Json(name = "images") val images: List<ImageData>? = null
) : SnippetData() {
    override fun setDefaults() {
        // no-op
    }
}
