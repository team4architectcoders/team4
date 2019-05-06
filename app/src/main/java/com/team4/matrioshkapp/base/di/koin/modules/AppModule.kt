package com.team4.matrioshkapp.base.di.koin.modules

import org.koin.dsl.module

val appModule = module {
    single { MatrioshKapp.appContext }
    }