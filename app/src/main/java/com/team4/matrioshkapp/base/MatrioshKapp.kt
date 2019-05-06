package com.team4.matrioshkapp.base.di.koin.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.team4.matrioshkapp.base.io.database.MatrioshkappDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

open class MatrioshKapp : Application() {
    companion object {
        const val DABASE_NAME = "matrioshkapp_db"
        lateinit var database: MatrioshkappDatabase
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this.applicationContext

        database = Room.databaseBuilder(
            this, MatrioshkappDatabase::class.java,
            DABASE_NAME
        ).build()

        val modules = arrayListOf(
            iOModule, appModule
        )

        startKoin {
            androidLogger()
            androidContext(this@MatrioshKapp)
            modules(modules)
        }
    }
}