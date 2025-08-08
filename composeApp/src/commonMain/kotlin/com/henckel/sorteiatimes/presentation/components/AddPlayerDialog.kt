package com.henckel.sorteiatimes.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.henckel.sorteiatimes.data.model.Player
import com.henckel.sorteiatimes.presentation.theme.Green
import com.henckel.sorteiatimes.presentation.theme.Theme

@Composable
fun AddPlayerDialog(
    positions: List<String>,
    onSave: (String, String) -> Unit,
    onDismiss: () -> Unit,
    onDelete: (Player) -> Unit,
    onUpdate: (Player) -> Unit,
    player: Player? = null
) {
    var name by remember { mutableStateOf(player?.name ?: "") }
    var selectedPosition by remember { mutableStateOf(positions.first()) }
    var expanded by remember { mutableStateOf(false) }

    Theme {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Adicionar Jogador") },
            text = {
                Column {

                    Spacer(Modifier.height(20.dp))

                    OutlinedTextField(
                        value = name,
                        onValueChange = { if(it.length <= 80) name = it },
                        label = { Text("Nome do Jogador") },
                        modifier = Modifier.fillMaxWidth(),

                        maxLines = 1
                    )

                    Spacer(Modifier.height(32.dp))

                    Box () {
                        OutlinedButton(
                            modifier = Modifier.height(50.dp).fillMaxWidth(),
                            onClick = { expanded = true },
                        ) {
                            Text(selectedPosition)
                        }

                        DropdownMenu(
                            modifier = Modifier.background(color = Color.White),
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            positions.forEach { position ->
                                DropdownMenuItem(
                                    modifier = Modifier.background(color = Color.White).fillMaxWidth(),
                                    text = { Text(position, color = Color.Black) },
                                    onClick = {
                                        selectedPosition = position
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }

                    Spacer(Modifier.height(20.dp))
                }
            },
            confirmButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Green,
                        contentColor = Green
                    ),
                    onClick = {
                        if(player == null){
                            onSave(name, selectedPosition)
                        } else{
                            player.name = name
                            player.position = Player.getPositions().indexOf(selectedPosition)
                            onUpdate(player)
                        }
                        onDismiss()
                    },
                    enabled = name.isNotBlank()
                ) {
                    Text("Salvar", color = Color.White)
                }
            },
            dismissButton = {
                OutlinedButton(onClick = {if(player == null) {
                    onDismiss()
                } else {
                    onDelete(player)
                    onDismiss()
                }}) {
                    if(player == null) Text("Cancelar") else Text("Deletar", color = Color.Red)
                }
            }
        )
    }

}
