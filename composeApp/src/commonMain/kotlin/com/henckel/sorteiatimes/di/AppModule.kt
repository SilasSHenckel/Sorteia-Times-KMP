package com.henckel.sorteiatimes.di

import com.henckel.sorteiatimes.data.di.dataModule
import com.henckel.sorteiatimes.domain.di.domainModule
import com.henckel.sorteiatimes.presentation.di.presentationModule

val appModules = listOf(
    dataModule,
    domainModule,
    presentationModule,
)