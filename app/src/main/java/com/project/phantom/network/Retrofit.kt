package com.project.phantom.network

import com.project.phantom.PhantomApplication
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.koin.android.ext.android.get
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val PHANTOM_BASE_URL = "http://localhost:8080"

fun createRetrofit(): Retrofit {
    val okHttpClient = PhantomApplication.INSTANCE.get<OkHttpClient>()
    val moshi = PhantomApplication.INSTANCE.get<Moshi>()

    return Retrofit.Builder()
        .baseUrl(PHANTOM_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}