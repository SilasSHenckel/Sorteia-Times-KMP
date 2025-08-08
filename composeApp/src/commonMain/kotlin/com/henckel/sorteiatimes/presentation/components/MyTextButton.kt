package com.henckel.sorteiatimes.presentation.components

import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun MyTextButton(onClick: () -> Unit, text: String) {
    IconButton(onClick = onClick) {
        Text(text, style = TextStyle(fontSize = 26.sp, fontWeight = FontWeight.Bold))
    }
}