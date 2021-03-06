package com.benbria.loopandroidrefapp

import android.app.Application
import com.benbria.loopandroidrefapp.di.mainModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class LoopApplication : Application() {

    companion object {
        lateinit var instance: LoopApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        startKoin {
            androidContext(applicationContext)
            modules(mainModules)
        }
        KoinApplication.logger = AndroidLogger()
    }
}