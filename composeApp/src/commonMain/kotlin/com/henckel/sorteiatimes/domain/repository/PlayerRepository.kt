package com.henckel.sorteiatimes.domain.repository

import com.henckel.sorteiatimes.data.model.Player
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {
    suspend fun insert(player: Player)
    suspend fun update(player: Player)
    suspend fun delete(player: Player)
    suspend fun getById(id: String): Player?
    suspend fun getAll(): Flow<List<Player>>
}