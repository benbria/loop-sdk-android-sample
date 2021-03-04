package com.benbria.loopandroidrefapp.main

import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.benbria.loopandroidrefapp.R
import com.benbria.loopandroidsdk.core.Loop
import com.benbria.loopandroidsdk.data.entities.InitResponse
import com.benbria.loopandroidsdk.data.listeners.InitListener
import com.benbria.loopandroidsdk.data.listeners.ViewListener
import com.benbria.loopandroidsdk.data.view.LoopWebView
import com.benbria.loopandroidsdk.domain.entities.Configuration
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Loop.getInstance(this).init(
            Configuration().apply {
                this.apiKey = "api_key"
                this.mobileChannelId = "channel_id"
            },
            object : InitListener {
                override fun displayRequested(webView: LoopWebView) {
                    val lp = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                    webview_container.addView(webView, lp)
                }

                override fun failure(message: String) {
                }

                override fun ready(initResponse: InitResponse) {

                }
            })

        button_survey.setOnClickListener {
            webview_container.removeAllViews()
            mainViewModel.view(baseContext, "00033", object : ViewListener {
                override fun onViewClose() {
                    webview_container.removeAllViews()
                }

                override fun onViewCreateError(message: String) {
                }

                override fun onViewCreated(view: LoopWebView) {
                    val lp = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                    webview_container.addView(view, lp)
                }

                override fun onViewError(message: String) {
                }
            })
        }
    }
}