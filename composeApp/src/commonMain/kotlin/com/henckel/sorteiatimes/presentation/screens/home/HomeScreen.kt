package com.henckel.sorteiatimes.presentation.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.henckel.sorteiatimes.data.model.Player
import com.henckel.sorteiatimes.presentation.components.AddPlayerDialog
import com.henckel.sorteiatimes.presentation.components.MyTextButton
import com.henckel.sorteiatimes.presentation.components.SolidButton
import com.henckel.sorteiatimes.presentation.strings.AppStrings
import com.henckel.sorteiatimes.presentation.theme.Blue
import com.henckel.sorteiatimes.presentation.theme.Green
import org.koin.compose.koinInject

@Composable
fun HomeScreen(navController: NavController) {

    val viewModel = koinInject<HomeViewModel>()

    val strings = AppStrings.strings

    var nTeams by remember { mutableStateOf(2) }
    val players by viewModel.players.collectAsStateWithLifecycle()
    val showDialog by viewModel.showDialog.collectAsStateWithLifecycle()

    Column (
        modifier = Modifier
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Card(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 14.dp).fillMaxWidth().weight(1f),
            shape = RoundedCornerShape(25.dp),
            border = BorderStroke(2.dp, Color.White),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(14.dp))
                Text(strings.players.uppercase(), style= TextStyle(fontSize = 24.sp))
                Spacer(modifier = Modifier.height(12.dp))
                HorizontalDivider(thickness = 2.dp, color = Color.White)
                LazyColumn {
                    itemsIndexed(players) { index, player ->
                        Row (
                            modifier = Modifier.fillMaxWidth().height(60.dp).clickable {
                                viewModel.openDialog(player)
                            },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(text = "${index + 1}", style= TextStyle(fontSize = 22.sp))
                            Spacer(modifier = Modifier.width(16.dp))
                            Column() {
                                Text(text = player.name ?: "", style= TextStyle(fontSize = 18.sp))
                                Text(text = Player.getPositions()[player.position ?: 0], style= TextStyle(fontSize = 14.sp))
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        SolidButton(text = strings.addPlayer, color = Green, onClick = { viewModel.openDialog() })

        Spacer(modifier = Modifier.height(14.dp))

        Row (
            modifier = Modifier.padding(horizontal = 14.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(strings.teams.uppercase(), style= TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))

            Card(
                modifier = Modifier.padding(start = 16.dp).fillMaxWidth().weight(1f),
                shape = RoundedCornerShape(25.dp),
                border = BorderStroke(2.dp, Color.White),
            ) {
                Row(
                    modifier = Modifier.padding(all = 4.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    MyTextButton(text = "-", onClick = { if(nTeams > 2) nTeams-- })
                    Text(nTeams.toString().uppercase(), style= TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
                    MyTextButton(text = "+", onClick = { if(nTeams < 41) nTeams++ })
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        SolidButton(text = strings.sortTeams, color = Blue, onClick = { viewModel.sortTeams(players, nTeams, navController)})
    }

    if (showDialog) {
        AddPlayerDialog(
            positions = Player.getPositions(),
            onSave = { name, position ->
                viewModel.savePlayer(name, position)
            },
            onDismiss = { viewModel.closeDialog() },
            onDelete = { viewModel.deletePlayer(it) },
            onUpdate = { viewModel.updatePlayer(it) },
            player = viewModel.playerSelected
        )
    }

}