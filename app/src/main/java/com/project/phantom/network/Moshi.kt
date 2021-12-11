package com.project.phantom.network

import com.project.phantom.ui.click.ClickDataPolymorphicAdapter
import com.project.phantom.ui.snippets.commons.SnippetApiDataPolymorphicAdapter
import com.project.phantom.ui.text.MarkdownSpanPolymorphicJsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

fun createMoshi(): Moshi {
    return Moshi.Builder()
        .add(SnippetApiDataPolymorphicAdapter)
        .add(ClickDataPolymorphicAdapter)
        .add(MarkdownSpanPolymorphicJsonAdapter)
        .addLast(KotlinJsonAdapterFactory())
        .build()
}
