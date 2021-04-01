package com.benbria.loopandroidrefapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TestApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@TestApplication)
            // no modules are loaded to begin with
            // modules will be loaded in respective tests as per requirement
            modules(emptyList())
        }
    }
}