package com.henckel.sorteiatimes.domain.usecase

import com.henckel.sorteiatimes.data.model.Player
import com.henckel.sorteiatimes.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow

class PlayerUseCase(private val repository: PlayerRepository) {

    suspend fun getAll(): Flow<List<Player>> {
        return repository.getAll()
    }

    suspend fun insert(player: Player) {
        repository.insert(player)
    }

    suspend fun update(player: Player) {
        repository.update(player)
    }

    suspend fun delete(player: Player) {
        repository.delete(player)
    }

    suspend fun getById(id: String): Player? {
        return repository.getById(id)
    }

// TODO -> Segregar em UseCases especificos
//    suspend operator fun invoke(): List<Player> {
//        return repository.getAll()
//    }

}