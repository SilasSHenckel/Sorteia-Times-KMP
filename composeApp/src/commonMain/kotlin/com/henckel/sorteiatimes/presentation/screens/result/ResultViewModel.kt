package com.henckel.sorteiatimes.presentation.screens.result

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ResultViewModel() : ViewModel() {

    private val _players = MutableStateFlow("")
    val players: StateFlow<String> = _players.asStateFlow()

}