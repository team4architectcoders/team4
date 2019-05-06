package com.team4.matrioshkapp.base.di.koin.modules

import org.koin.dsl.module

//DAOs
val iOModule = module {
    single { MatrioshKapp.database }
}