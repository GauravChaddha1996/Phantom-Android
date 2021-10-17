package com.project.phantom.network

import com.project.phantom.data.atoms.click.ClickDataPolymorphicAdapter
import com.project.phantom.data.snippets.base.SnippetNetworkDataPolymorphicAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

fun createMoshi(): Moshi {
    return Moshi.Builder()
        .add(SnippetNetworkDataPolymorphicAdapter)
        .add(ClickDataPolymorphicAdapter)
        .addLast(KotlinJsonAdapterFactory())
        .build()
}