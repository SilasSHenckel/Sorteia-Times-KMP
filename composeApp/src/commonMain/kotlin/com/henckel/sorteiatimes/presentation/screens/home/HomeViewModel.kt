package com.henckel.sorteiatimes.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.henckel.sorteiatimes.data.model.Player
import com.henckel.sorteiatimes.domain.usecase.PlayerUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val playerUseCase: PlayerUseCase
) : ViewModel() {

    private val _players = MutableStateFlow<List<Player>>(emptyList())
    val players: StateFlow<List<Player>> = _players.asStateFlow()

    init {
        loadAllPlayers()
    }

    fun loadAllPlayers() = viewModelScope.launch {
        playerUseCase.getAll().catch { e ->
            //TODO TRATAR POSSIVEIS ERROS
        }
        .collect { playerList ->
            _players.value = playerList
        }
    }
}