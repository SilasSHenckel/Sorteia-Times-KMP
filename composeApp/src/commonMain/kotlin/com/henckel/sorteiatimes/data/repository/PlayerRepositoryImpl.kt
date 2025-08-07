package com.henckel.sorteiatimes.data.repository

import com.henckel.sorteiatimes.data.model.Player
import com.henckel.sorteiatimes.domain.repository.PlayerRepository

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlayerRepositoryImpl(
    private val realm: Realm
) : PlayerRepository{

    override suspend fun insert(player: Player) {
        realm.write { player }
    }

    override suspend fun update(player: Player) {
        realm.write {
            val pl = query<Player>("id == $0", player.id).first().find()
            if (pl != null) {
                pl.name = player.name
                pl.rate = player.rate
                pl.position = player.position
            }
        }
    }

    override suspend fun delete(player: Player) {
        realm.write {
            val user = query<Player>("id == $0", player.id).first().find()
            if (user != null) delete(user)
        }
    }

    override suspend fun getById(id: String): Player? {
        return realm.query<Player>("id == $id LIMIT(1)").first().find()
    }

    override suspend fun getAll(): Flow<List<Player>> {
        return realm.query(Player::class).asFlow().map { it.list }
    }
}