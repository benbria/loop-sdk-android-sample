package com.benbria.loopandroidrefapp.di

import com.benbria.loopandroidrefapp.main.MainViewModel
import org.koin.dsl.module

var mainModules = module {

    factory { MainViewModel() }
}