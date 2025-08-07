package com.henckel.sorteiatimes

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import br.com.crearesistemas.appconfigurator.theme.Theme
import com.henckel.sorteiatimes.presentation.strings.LocalStrings
import com.henckel.sorteiatimes.presentation.strings.LocalizationManager
import com.henckel.sorteiatimes.presentation.strings.PlatformLanguageProvider
import com.henckel.sorteiatimes.presentation.strings.SupportedLanguage
import com.henckel.sorteiatimes.di.appModules
import com.henckel.sorteiatimes.presentation.navigation.AppNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {

    InitStringsLanguage()

    KoinApplication(application = {
        modules(appModules)
    }) {
        CompositionLocalProvider(LocalStrings provides LocalizationManager.getCurrentStrings()) {
            Theme {
                Scaffold(
                    modifier = Modifier.padding(WindowInsets.navigationBars.asPaddingValues())
                ) {
                    AppNavigation()
                }
            }
        }
    }

}

@Composable
fun InitStringsLanguage(){
    val platformLanguage = remember { PlatformLanguageProvider().getCurrentLanguageCode() }
    val language = remember(platformLanguage) {
        when (platformLanguage) {
            "en" -> SupportedLanguage.ENGLISH
            else -> SupportedLanguage.PORTUGUESE
        }
    }

    LocalizationManager.setLanguage(language)
}