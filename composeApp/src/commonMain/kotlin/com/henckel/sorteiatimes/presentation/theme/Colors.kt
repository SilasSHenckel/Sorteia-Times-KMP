package br.com.crearesistemas.appconfigurator.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val DarkBackground = Color(17, 17, 17)
val LightBackGround = Color.White
val PrimaryColor = Color(0xFFBB2424)
val SecondaryColor = Color.Gray
val GrayBackground = Color(63, 60, 61)
val ToastSuccessBackground = Color(0xCC9FF08F)
val ToastSuccessBorder = Color(0xFF38B670)
val ToastErrorBackground = Color(0xCCFF6B6B)
val ToastErrorBorder = Color(0xFFFF5454)

internal val LightColorScheme = lightColorScheme(
    background = LightBackGround, //branco/preto
    primary = PrimaryColor, //sempre vermelho
    onPrimary = DarkBackground, // preto/branco
    secondary = SecondaryColor, //sempre cinza
    tertiary = LightBackGround, //sempre branco
    tertiaryContainer = LightBackGround, //branco/cinza
    surface = DarkBackground, //sempre preto
    surfaceContainer = ToastSuccessBackground, //sempre verde
    surfaceVariant = ToastSuccessBorder, //sempre verde, Borda
    onErrorContainer = ToastErrorBackground, // sempre vermelho
    error = ToastErrorBorder, // sempre vermelho, borda
)

internal val DarkColorScheme = darkColorScheme(
    background = DarkBackground,
    primary = PrimaryColor,
    onPrimary = LightBackGround,
    secondary = SecondaryColor,
    tertiary = LightBackGround,
    tertiaryContainer = GrayBackground,
    surface = DarkBackground,
    surfaceContainer = ToastSuccessBackground,
    surfaceVariant = ToastSuccessBorder
)

