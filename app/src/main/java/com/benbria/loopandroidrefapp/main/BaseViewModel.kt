package com.benbria.loopandroidrefapp.main

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {

    lateinit var lifecycleOwner: LifecycleOwner

    fun injectLifeCycleOwner(viewLifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = viewLifecycleOwner
        onLifecycleOwnerSet()
    }

    abstract fun onLifecycleOwnerSet()
}