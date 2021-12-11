import com.project.phantom.buildsrc.Libs

plugins {
    id("com.android.application")
    id("org.jmailen.kotlinter") version "3.7.0"
    kotlin("android")
    kotlin("kapt")
}

android {
    defaultConfig {
        applicationId = "com.project.phantom"
        compileSdk = 31
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(name = "proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Libs.Compose.version
    }
}

dependencies {
    // Basic dependencies
    implementation(Libs.AndroidX.core)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.material)
    implementation(Libs.AndroidX.lifecycleRuntime)

    // Compose related dependencies
    implementation(Libs.Compose.ui)
    implementation(Libs.Compose.material)
    implementation(Libs.Compose.runtime)
    implementation(Libs.Compose.activityIntegration)
    implementation(Libs.Compose.runtimeLivedata)
    implementation(Libs.Compose.uiTooling)
    debugImplementation(Libs.Compose.uiToolingPreview)

    // Moshi
    implementation(Libs.Moshi.core)
    implementation(Libs.Moshi.kotlin)
    implementation(Libs.Moshi.adapters)
    kapt(Libs.Moshi.codegen)

    // Koin
    implementation(Libs.Koin.core)
    implementation(Libs.Koin.android)
    implementation(Libs.Koin.compose)

    // Retrofit
    implementation(Libs.Retrofit.core)
    implementation(Libs.Retrofit.moshiConverter)

    // Coil
    implementation(Libs.Coil.core)
    implementation(Libs.Coil.compose)

    // Swipe refresh
    implementation(Libs.Accompanist.swipeRefresh)

    // Test related
    testImplementation(Libs.Test.junit_core)
    androidTestImplementation(Libs.Test.junitTextExt)
    androidTestImplementation(Libs.Test.espresso)
    androidTestImplementation(Libs.Test.composeTest)
}

kotlinter {
    ignoreFailures = false
    indentSize = 4
    reporters = arrayOf("checkstyle", "plain")
    experimentalRules = true
    disabledRules = emptyArray<String>()
}

tasks.check {
    dependsOn("installKotlinterPrePushHook")
}