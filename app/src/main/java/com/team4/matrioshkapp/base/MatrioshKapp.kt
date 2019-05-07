package com.team4.matrioshkapp.base.di.koin.modules

import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

open class MatrioshKapp : Application() {
    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this.applicationContext

        val modules = arrayListOf(
            appModule
        )

        startKoin {
            androidLogger()
            androidContext(this@MatrioshKapp)
            modules(modules)
        }
    }
}