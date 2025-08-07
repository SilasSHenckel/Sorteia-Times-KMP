package com.henckel.sorteiatimes.presentation.strings

import java.util.Locale

actual class PlatformLanguageProvider {
    actual fun getCurrentLanguageCode(): String {
        return Locale.getDefault().language
    }
}