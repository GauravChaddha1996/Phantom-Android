package com.project.phantom.network

import com.project.phantom.PhantomApplication
import okhttp3.OkHttpClient
import org.koin.android.ext.android.get
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val PHANTOM_BASE_URL = "http://localhost:8080"

fun createRetrofit(): Retrofit {
    val okHttpClient = PhantomApplication.INSTANCE.get<OkHttpClient>()
    return Retrofit.Builder()
        .baseUrl(PHANTOM_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}