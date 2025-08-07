package com.henckel.sorteiatimes.presentation.strings

import platform.Foundation.NSLocale
import platform.Foundation.currentLocale
import platform.Foundation.languageCode

actual class PlatformLanguageProvider {
    actual fun getCurrentLanguageCode(): String {
        return NSLocale.currentLocale.languageCode ?: "en" // fallback para "en" se for null
    }
}