package com.benbria.loopandroidrefapp.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.benbria.loopandroidrefapp.R
import com.benbria.loopandroidsdk.core.Loop
import com.benbria.loopandroidsdk.data.entities.InitResponse
import com.benbria.loopandroidsdk.data.listeners.InitListener
import com.benbria.loopandroidsdk.domain.entities.Configuration
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), InitListener {

    private val LOG_TAG = MainActivity::class.java.simpleName

    private val loopInstance = Loop.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loopInstance.init(
            Configuration("6054c5146df5a259081d52c2")
                .apply {
                    this.accountId = "4f0f298c1808714405000002"
                }, this
        )

        button_survey.setOnClickListener {
            val intent = Intent(baseContext, WebViewActivity::class.java)
            intent.putExtra("EXTRA_EXPERIENCE_ID", "5ed581ce61a3dcc4c627c91d")
            startActivity(intent)
        }

        button_messenger.setOnClickListener {
            val intent = Intent(baseContext, WebViewActivity::class.java)
            intent.putExtra("EXTRA_EXPERIENCE_ID", "5ed64f7abee23d481e63f28e")
            startActivity(intent)
        }

        button_nlp.setOnClickListener {
            val intent = Intent(baseContext, WebViewActivity::class.java)
            intent.putExtra("EXTRA_EXPERIENCE_ID", "60469ce6a54f63642a698a13")
            startActivity(intent)
        }

        fab.setOnClickListener {
            val intent = Intent(baseContext, WebViewActivity::class.java)
            intent.putExtra("EXTRA_EXPERIENCE_ID", it.tag.toString())
            startActivity(intent)

            fab.tag = null
            fab.visibility = View.GONE
        }
    }

    // InitListener Callbacks
    override fun displayRequested(experienceId: String) {
        fab.tag = experienceId
        fab.visibility = View.VISIBLE
    }

    override fun failure(message: String) {
        Log.i(LOG_TAG, message)
    }

    override fun ready(initResponse: InitResponse) {
    }


}