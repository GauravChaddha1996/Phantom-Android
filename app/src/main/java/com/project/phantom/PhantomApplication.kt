package com.project.phantom

import android.app.Application
import coil.Coil
import coil.ImageLoader
import com.project.phantom.koin.AppModule
import com.project.phantom.koin.CategoryModule
import com.project.phantom.koin.HomeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

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
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@PhantomApplication)
            modules(AppModule, HomeModule, CategoryModule)
        }

        // Setup coil for image loading
        val imageLoader = ImageLoader.Builder(this).build()
        Coil.setImageLoader(imageLoader)
    }
}
