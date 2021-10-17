package com.project.phantom

import android.app.Application
import com.project.phantom.koin.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class PhantomApplication : Application(), KoinComponent {

    companion object {
        lateinit var INSTANCE: PhantomApplication
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        // Start dependency injection
        startKoin {
            allowOverride(false)
            androidLogger()
            androidContext(this@PhantomApplication)
            modules(AppModule)
        }
    }
}