package com.example.paywithbitcoin

import android.app.Application
import com.example.paywithbitcoin.data.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PayWithBitcoin: Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PayWithBitcoin)
            modules(listOf(viewModelModule, repositoryModule, netModule, APIModule, databaseModule))
        }
    }
}