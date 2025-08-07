package com.henckel.sorteiatimes.presentation.strings

import com.henckel.sorteiatimes.presentation.strings.resources.StringResources

object AppStrings {
    private val strings: StringResources
        get() = LocalizationManager.getCurrentStrings()

    object HomeScreen {
        val TEXT1 get() = strings.text1
    }

}