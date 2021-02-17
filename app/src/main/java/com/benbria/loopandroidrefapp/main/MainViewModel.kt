package com.benbria.loopandroidrefapp.main

import android.content.Context
import com.benbria.loopandroidsdk.core.Loop
import com.benbria.loopandroidsdk.data.listeners.ViewListener

class MainViewModel(): BaseViewModel() {

    override fun onLifecycleOwnerSet() {

    }

    fun view(context: Context, surveyId: String, viewListener: ViewListener? = null) = Loop.getInstance(context).view(surveyId, viewListener)

}