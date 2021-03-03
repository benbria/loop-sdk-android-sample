package com.benbria.loopandroidrefapp

import android.app.Application
import com.benbria.loopandroidrefapp.di.mainModules
import com.benbria.loopandroidsdk.core.Loop
import com.benbria.loopandroidsdk.data.listeners.InitListener
import com.benbria.loopandroidsdk.data.view.LoopWebView
import com.benbria.loopandroidsdk.domain.entities.Configuration
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

        Loop.getInstance(this).init(
                Configuration().apply {
                    this.apiKey = "api_key"
                    this.mobileChannelId = "channel_id"
                },
                object : InitListener {
                    override fun displayRequested(webView: LoopWebView) {
                    }

                    override fun failure(message: String) {
                    }

                    override fun ready() {
                    }
                })
    }
}