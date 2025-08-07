package com.henckel.sorteiatimes.domain.di

import com.henckel.sorteiatimes.domain.usecase.PlayerUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { PlayerUseCase(get()) }
}