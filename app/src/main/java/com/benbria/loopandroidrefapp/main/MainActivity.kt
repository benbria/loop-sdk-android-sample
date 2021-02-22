package com.benbria.loopandroidrefapp.main

import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.benbria.loopandroidrefapp.R
import com.benbria.loopandroidsdk.data.listeners.ViewListener
import com.benbria.loopandroidsdk.data.view.LoopWebView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_survey.setOnClickListener {
            webview_container.removeAllViews()

            mainViewModel.view(baseContext, "surveyid1", null, object : ViewListener {
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

        button_survey_with_location.setOnClickListener {
            webview_container.removeAllViews()
            mainViewModel.view(baseContext, "surveyid1", "0079", object : ViewListener {
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

        button_messenger.setOnClickListener {
            webview_container.removeAllViews()
            mainViewModel.view(baseContext, "chfwebmessenger", "00033", object : ViewListener {
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