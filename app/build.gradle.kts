import com.project.phantom.buildsrc.Libs

// Plugins this module depends on
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("org.jmailen.kotlinter") version "3.7.0"
    id("io.gitlab.arturbosch.detekt") version("1.19.0")
}

android {
    defaultConfig {
        applicationId = "com.project.phantom"
        compileSdk = 31
        minSdk = 23
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        signingConfig = signingConfigs.getByName("debug")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
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
    implementation(Libs.Compose.compiler)
    implementation(Libs.Compose.foundation)
    implementation(Libs.Compose.runtime)
    implementation(Libs.Compose.runtimeLivedata)
    implementation(Libs.Compose.ui)
    implementation(Libs.Compose.material3)
    implementation(Libs.Compose.animation)
    implementation(Libs.Compose.uiTooling)
    debugImplementation(Libs.Compose.uiToolingPreview)
    implementation(Libs.Compose.activityIntegration)

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

    // System UI controller
    implementation(Libs.Accompanist.systemUiController)

    // Pager
    implementation(Libs.Accompanist.pager)
    implementation(Libs.Accompanist.pagerIndicators)

    // Room
    implementation(Libs.Room.runtime)
    annotationProcessor(Libs.Room.compiler)
    kapt(Libs.Room.compiler)

    // Leak canary
    debugImplementation(Libs.LeakCanary.core)

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