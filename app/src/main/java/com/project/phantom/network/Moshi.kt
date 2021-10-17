package com.project.phantom.network

import com.project.phantom.data.uiModels.snippets.base.BaseSnippetNetworkDataPolymorphicAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

fun createMoshi(): Moshi {
    return Moshi.Builder()
        .add(BaseSnippetNetworkDataPolymorphicAdapter)
        .addLast(KotlinJsonAdapterFactory())
        .build()
}