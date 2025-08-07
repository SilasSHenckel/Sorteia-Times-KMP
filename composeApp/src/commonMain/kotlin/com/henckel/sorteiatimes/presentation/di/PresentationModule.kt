package com.henckel.sorteiatimes.presentation.di

import com.henckel.sorteiatimes.presentation.screens.home.HomeViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { HomeViewModel(get()) }
}


