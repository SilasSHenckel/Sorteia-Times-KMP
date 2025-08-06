package com.henckel.sorteiatimes

import androidx.compose.ui.window.ComposeUIViewController
import com.henckel.sorteiatimes.di.initKoin

fun MainViewController() = ComposeUIViewController {
    initKoin()
    App()
}