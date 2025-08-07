package com.henckel.sorteiatimes.data.repository

import com.henckel.sorteiatimes.data.model.Player
import com.henckel.sorteiatimes.domain.repository.PlayerRepository

class PlayerRepositoryImpl(

) : PlayerRepository{
    override suspend fun getAll(): List<Player> {
        return listOf()
    }
}