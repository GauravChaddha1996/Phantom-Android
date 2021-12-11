package com.project.phantom.koin

import com.project.phantom.network.createMoshi
import com.project.phantom.network.createOkHttpClient
import com.project.phantom.network.createRetrofit
import org.koin.dsl.module

val AppModule = module {
    single { createMoshi() }
    single { createOkHttpClient() }
    single { createRetrofit() }
}
