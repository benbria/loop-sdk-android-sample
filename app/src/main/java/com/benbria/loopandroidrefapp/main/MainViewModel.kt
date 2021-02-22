package com.benbria.loopandroidrefapp.main

import android.content.Context
import com.benbria.loopandroidsdk.core.Loop
import com.benbria.loopandroidsdk.data.listeners.ViewListener
import com.benbria.loopandroidsdk.domain.entities.UserInfo

class MainViewModel() : BaseViewModel() {

    override fun onLifecycleOwnerSet() {

    }

    fun view(context: Context, channelId: String, locationId: String? = null, viewListener: ViewListener? = null) =
        Loop.getInstance(context).view(channelId, locationId, UserInfo().apply { this.name = "John" }, viewListener)

}