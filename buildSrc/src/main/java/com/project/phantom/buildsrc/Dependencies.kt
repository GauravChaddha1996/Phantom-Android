/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.project.phantom.buildsrc

object Libs {
    object AndroidX {
        // Allows access to new APIs on older API versions of the platform
        const val core = "androidx.core:core-ktx:1.7.0"
        const val appCompat = "androidx.appcompat:appcompat:1.4.0"

        const val material = "com.google.android.material:material:1.4.0"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0"
        const val compose = "androidx.activity:activity-compose:1.4.0"
    }

    object Accompanist {
        const val swipeRefresh = "com.google.accompanist:accompanist-swiperefresh:0.18.0"
        const val pager = "com.google.accompanist:accompanist-pager:0.20.3"
        const val pagerIndicators = "com.google.accompanist:accompanist-pager-indicators:0.20.3"
        const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:0.22.0-rc"
    }

    object Compose {
        const val version = "1.0.5"
        private const val animationVersion = "1.1.0-rc01"
        private const val material3Version = "1.0.0-alpha03"
        const val compiler = "androidx.compose.compiler:compiler:$version"
        const val foundation = "androidx.compose.foundation:foundation:$version"
        const val runtime = "androidx.compose.runtime:runtime:$version"
        const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
        const val ui = "androidx.compose.ui:ui:$version"
        const val material = "androidx.compose.material:material:$version"
        const val material3 = "androidx.compose.material3:material3:$material3Version"
        const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val animation = "androidx.compose.animation:animation:$animationVersion"
        const val activityIntegration = "androidx.activity:activity-compose:1.4.0"
    }

    object Moshi {
        private const val version = "1.12.0"
        const val core = "com.squareup.moshi:moshi:$version"
        const val kotlin = "com.squareup.moshi:moshi-kotlin:$version"
        const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
        const val adapters = "com.squareup.moshi:moshi-adapters:$version"
    }

    object Koin {
        private const val version = "3.1.2"
        const val core = "io.insert-koin:koin-core:$version"
        const val android = "io.insert-koin:koin-android:$version"
        const val compose = "io.insert-koin:koin-androidx-compose:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val core = "com.squareup.retrofit2:retrofit:$version"
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$version"
    }

    object Coil {
        private const val version = "1.4.0"
        const val core = "io.coil-kt:coil:$version"
        const val compose = "io.coil-kt:coil-compose:$version"
    }

    object Room {
        private const val version = "2.4.1"
        const val runtime = "androidx.room:room-runtime:$version"
        const val compiler = "androidx.room:room-compiler:$version"
    }

    object Test {
        const val junit_core = "junit:junit:4.13.2"
        const val junitTextExt = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
        const val composeTest = "androidx.compose.ui:ui-test-junit4:${Compose.version}"
    }
}