package com.henckel.sorteiatimes.di

import org.koin.core.module.Module
import org.koin.dsl.module

val appModule = module {
//    single { MyRepository(get()) }
//    single<RemoteDataSource> { RemoteDataSourceImpl() }
}

val appModules = listOf(
    appModule,
)