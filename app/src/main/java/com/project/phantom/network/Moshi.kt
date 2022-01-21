package com.project.phantom.network

import com.project.phantom.ui.click.ClickDataPolymorphicAdapter
import com.project.phantom.ui.snippets.commons.SnippetDataPolymorphicAdapter
import com.project.phantom.ui.text.MarkdownSpanPolymorphicJsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

fun createMoshi(): Moshi {
    return Moshi.Builder()
        .add(SnippetDataPolymorphicAdapter)
        .add(ClickDataPolymorphicAdapter)
        .add(MarkdownSpanPolymorphicJsonAdapter)
        .addLast(KotlinJsonAdapterFactory())
        .build()
}
