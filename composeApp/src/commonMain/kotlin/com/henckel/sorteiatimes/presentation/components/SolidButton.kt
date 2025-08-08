package com.henckel.sorteiatimes.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SolidButton(text: String, onClick: () -> Unit, color: Color = Color.Black, textColor: Color = Color.White) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(25.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = color
        ),
        modifier = Modifier
            .padding(horizontal = 14.dp)
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(text.uppercase(), color= textColor, style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
    }
}