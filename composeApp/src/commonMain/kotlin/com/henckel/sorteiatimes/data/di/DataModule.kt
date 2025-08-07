package com.henckel.sorteiatimes.data.di

import com.henckel.sorteiatimes.data.repository.PlayerRepositoryImpl
import com.henckel.sorteiatimes.domain.repository.PlayerRepository
import com.henckel.sorteiatimes.domain.usecase.PlayerUseCase
import org.koin.dsl.module

val dataModule = module {

    single<PlayerRepository> { PlayerRepositoryImpl() }
    factory { PlayerUseCase(get()) }

}