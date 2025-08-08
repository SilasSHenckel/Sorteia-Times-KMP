package com.henckel.sorteiatimes.presentation.screens.result

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.henckel.sorteiatimes.data.model.Player
import com.henckel.sorteiatimes.presentation.components.SolidButton
import com.henckel.sorteiatimes.presentation.screens.home.HomeViewModel
import com.henckel.sorteiatimes.presentation.theme.Blue
import org.koin.compose.koinInject

@Composable
fun ResultScreen(navController: NavController) {
    val viewModel = koinInject<HomeViewModel>()

    LazyColumn(
        modifier = Modifier
            .safeContentPadding()
            .fillMaxSize()
            .padding(bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Text("Times Sorteados:".uppercase(), style= TextStyle(fontSize = 24.sp))
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }


        viewModel.teamsMap.forEach { (key, value) ->
            item {
                TeamContent(key.toString(), value)
            }
        }

        item {
            Spacer(modifier = Modifier.height(28.dp))
        }

        item {
            SolidButton(text = "Voltar", color = Blue, onClick = { navController.popBackStack() })
        }
    }
}

@Composable
fun TeamContent(time: String, players: List<Player>) {
    Card(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 14.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(25.dp),
        border = BorderStroke(2.dp, Color.White),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("TIME $time", style = TextStyle(fontSize = 24.sp))
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(thickness = 2.dp, color = Color.White)
            Column {
                players.forEachIndexed { index, player ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(text = "${index + 1}", style = TextStyle(fontSize = 20.sp))
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(text = player.name ?: "", style = TextStyle(fontSize = 16.sp))
                            Text(
                                text = Player.getPositions()[player.position ?: 0],
                                style = TextStyle(fontSize = 12.sp)
                            )
                        }
                    }
                }
            }
        }
    }
}
