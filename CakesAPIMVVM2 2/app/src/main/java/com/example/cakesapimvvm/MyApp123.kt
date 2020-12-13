package com.example.cakesapimvvm

import android.app.Application
import com.example.cakesapimvvm.di.*
import com.firstcode.mvvm_breakinapi.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp123: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp123)
            androidLogger(Level.ERROR)
            modules(repositoryModule, netModule, apiModule, databaseModule,viewModelModule )
        }
    }
}