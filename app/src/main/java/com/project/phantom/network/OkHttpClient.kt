package com.project.phantom.network

import coil.util.CoilUtils
import com.project.phantom.PhantomApplication
import okhttp3.OkHttpClient

fun createOkHttpClient(): OkHttpClient {
    val appContext = PhantomApplication.INSTANCE.applicationContext
    val cache = CoilUtils.createDefaultCache(appContext)
    return OkHttpClient.Builder()
        .cache(cache)
        .build()
}
