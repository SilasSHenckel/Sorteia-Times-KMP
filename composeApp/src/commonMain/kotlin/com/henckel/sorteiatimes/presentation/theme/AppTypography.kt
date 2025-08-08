package com.henckel.sorteiatimes.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import sorteiatimes.composeapp.generated.resources.Archivo_Regular
import sorteiatimes.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun AppTypography(): Typography {
    val Archivo = FontFamily(
        Font(Res.font.Archivo_Regular, FontWeight.Normal),
    )
    return Typography(
        headlineLarge = TextStyle(
            fontFamily = Archivo,
            fontWeight = FontWeight.Light,
            fontSize = 24.sp
        ),
    )
}

