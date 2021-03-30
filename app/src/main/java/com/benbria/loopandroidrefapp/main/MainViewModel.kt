package com.benbria.loopandroidrefapp.main

import android.content.Context
import com.benbria.loopandroidsdk.core.Loop
import com.benbria.loopandroidsdk.data.listeners.ViewListener
import com.benbria.loopandroidsdk.domain.entities.Info
import com.benbria.loopandroidsdk.domain.entities.Location
import com.benbria.loopandroidsdk.domain.entities.User

class MainViewModel() : BaseViewModel() {

    override fun onLifecycleOwnerSet() {

    }

    fun view(context: Context, experienceId: String, viewListener: ViewListener? = null) =
            Loop.getInstance(context).view(experienceId,
                    Info().apply {
                        this.user = User().apply {
                            this.name = "John"
                            this.lastName = "Who"
                            this.extras = mapOf(Pair("key1", "value1"))
                        }
                        this.context = com.benbria.loopandroidsdk.domain.entities.Context().apply {
                            this.location = Location().apply {
                                this.name = "Hotel California "
                            }
                            this.extras = mapOf(Pair("key1", "value1"))
                        }
                    }, viewListener)

}