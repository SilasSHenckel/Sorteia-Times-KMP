package com.henckel.sorteiatimes.data.di

import com.henckel.sorteiatimes.data.model.Player
import com.henckel.sorteiatimes.data.repository.PlayerRepositoryImpl
import com.henckel.sorteiatimes.domain.repository.PlayerRepository
import com.henckel.sorteiatimes.domain.usecase.PlayerUseCase
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.dsl.module

val dataModule = module {

    //Realm
    single {
        Realm.open(
            configuration = RealmConfiguration.create(schema = setOf(Player::class))
        )
    }

    single<PlayerRepository> { PlayerRepositoryImpl(get()) }
    factory { PlayerUseCase(get()) }

}