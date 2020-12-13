package com.example.paywithbitcoin

import android.app.Application
import com.example.paywithbitcoin.di.*
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@HiltAndroidApp
class PayWithBitcoin: Application(){
    override fun onCreate() {
        super.onCreate()
        /**
         * Start Koin
         */
        startKoin {
            androidContext(this@PayWithBitcoin)
            androidLogger(Level.NONE)
            modules(listOf(viewModelModule, repositoryModule, netModule, APIModule, databaseModule))
        }
    }
}