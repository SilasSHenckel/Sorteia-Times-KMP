package com.henckel.sorteiatimes.presentation.strings
import androidx.compose.runtime.staticCompositionLocalOf
import com.henckel.sorteiatimes.presentation.strings.resources.EnglishStrings
import com.henckel.sorteiatimes.presentation.strings.resources.PortugueseStrings
import com.henckel.sorteiatimes.presentation.strings.resources.StringResources

enum class SupportedLanguage {
    ENGLISH,
    PORTUGUESE
}

class LocalizationManager {
    companion object {
        private var currentLanguage = SupportedLanguage.PORTUGUESE

        fun getCurrentStrings(): StringResources {
            return when (currentLanguage) {
                SupportedLanguage.ENGLISH -> EnglishStrings()
                SupportedLanguage.PORTUGUESE -> PortugueseStrings()
            }
        }

        fun setLanguage(language: SupportedLanguage) {
            currentLanguage = language
        }
    }
}

val LocalStrings = staticCompositionLocalOf<StringResources> { PortugueseStrings() }