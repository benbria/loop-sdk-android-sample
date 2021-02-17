package com.benbria.loopandroidrefapp.main

import android.os.Bundle
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

        button.setOnClickListener {
            mainViewModel.view(baseContext,"id1", object : ViewListener {
                override fun onViewClose() {
                    webview_container.removeAllViews()
                }

                override fun onViewCreateError(message: String) {
                }

                override fun onViewCreated(view: LoopWebView) {
                    webview_container.addView(view)
                }

                override fun onViewError(message: String) {
                }
            })
        }
    }
}