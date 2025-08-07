package com.henckel.sorteiatimes.domain.usecase

import com.henckel.sorteiatimes.data.model.Player
import com.henckel.sorteiatimes.domain.repository.PlayerRepository

class PlayerUseCase(private val repository: PlayerRepository) {
    suspend operator fun invoke(): List<Player> {
        return repository.getAll()
    }
}