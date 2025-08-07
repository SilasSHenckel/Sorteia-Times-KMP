package com.henckel.sorteiatimes.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.henckel.sorteiatimes.domain.usecase.PlayerUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(
    private val playerUseCase: PlayerUseCase
) : ViewModel() {

    private val _players = MutableStateFlow("")
    val players: StateFlow<String> = _players.asStateFlow()

    init {

    }
}