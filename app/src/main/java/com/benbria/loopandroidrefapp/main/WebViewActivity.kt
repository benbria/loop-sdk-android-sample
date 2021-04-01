package com.benbria.loopandroidrefapp.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.benbria.loopandroidrefapp.R
import com.benbria.loopandroidsdk.data.listeners.ViewListener
import com.benbria.loopandroidsdk.data.view.LoopWebView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class WebViewActivity : AppCompatActivity(), ViewListener {
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        intent.getStringExtra("EXTRA_EXPERIENCE_ID")?.let {
            webview_container.removeAllViews()
            mainViewModel.view(baseContext, it, this)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }

    override fun onViewClose() {
        onBackPressed()
    }

    override fun onViewCreateError(message: String) {

    }

    override fun onViewCreated(view: LoopWebView) {
        val lp = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        )
        webview_container.addView(view, lp)
    }

    override fun onViewError(message: String) {

    }
}