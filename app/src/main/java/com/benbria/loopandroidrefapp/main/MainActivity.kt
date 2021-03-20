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

class MainActivity : AppCompatActivity(), ViewListener, InitListener {

    private val mainViewModel: MainViewModel by viewModel()
    private val loopInstance = Loop.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loopInstance.init(
            Configuration().apply {
                this.apiKey = "api_key"
                this.mobileChannelId = "channel_id"
            },this)

        button_survey.setOnClickListener {
            webview_container.removeAllViews()
            mainViewModel.view(baseContext, "604fa23dd568b8a48631c150", this)
        }
    }

    // ViewListener Callbacks
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

    // InitListener Callbacks
    override fun displayRequested(experienceId: String) {
        mainViewModel.view(baseContext, experienceId, this)
    }

    override fun failure(message: String) {
    }

    override fun ready(initResponse: InitResponse) {
    }


}