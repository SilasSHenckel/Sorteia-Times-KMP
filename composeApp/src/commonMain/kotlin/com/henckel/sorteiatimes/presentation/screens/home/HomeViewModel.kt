package com.henckel.sorteiatimes.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.henckel.sorteiatimes.data.model.Player
import com.henckel.sorteiatimes.domain.usecase.PlayerUseCase
import com.henckel.sorteiatimes.presentation.navigation.AppScreens
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

    private val _showDialog = MutableStateFlow(false)
    val showDialog: StateFlow<Boolean> = _showDialog

    var teamsMap : HashMap<Int, MutableList<Player>> = hashMapOf()
    var playerSelected: Player? = null

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

    fun deletePlayer(player: Player) = viewModelScope.launch {
        playerUseCase.delete(player)
    }

    fun updatePlayer(player: Player) = viewModelScope.launch {
        playerUseCase.update(player)
    }

    fun openDialog(player: Player? = null) {
        _showDialog.value = true
        playerSelected = player
    }

    fun closeDialog() {
        _showDialog.value = false
    }

    fun savePlayer(name: String, position: String) = viewModelScope.launch {

        val player = Player()
        player.name = name
        player.position = Player.getPositions().indexOf(position)
        player.rate = 0

        playerUseCase.insert(player)
    }

    fun sortTeams(players: List<Player>, nTeams: Int, navController: NavController){

        val shuffledPlayers = players.shuffled()
        val teamsMap = HashMap<Int, MutableList<Player>>()

        for (i in 1..nTeams) {
            teamsMap[i] = mutableListOf()
        }

        shuffledPlayers.forEachIndexed { index, player ->
            val teamNumber = (index % nTeams) + 1
            teamsMap[teamNumber]?.add(player)
        }

        this.teamsMap = teamsMap

        navController.navigate(AppScreens.SortResultScreen.name)
    }

}