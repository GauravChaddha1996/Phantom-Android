package com.project.phantom.network

import coil.util.CoilUtils
import com.project.phantom.PhantomApplication
import okhttp3.OkHttpClient

fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .cache(CoilUtils.createDefaultCache(PhantomApplication.INSTANCE.applicationContext))
        .build()
}