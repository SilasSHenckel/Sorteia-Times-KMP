package com.henckel.sorteiatimes.domain.repository

import com.henckel.sorteiatimes.data.model.Player

interface PlayerRepository {
    suspend fun getAll(): List<Player>
}