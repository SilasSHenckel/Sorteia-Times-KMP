package com.henckel.sorteiatimes.presentation.strings

import com.henckel.sorteiatimes.presentation.strings.resources.StringResources

object AppStrings {
    val strings: StringResources
        get() = LocalizationManager.getCurrentStrings()
}