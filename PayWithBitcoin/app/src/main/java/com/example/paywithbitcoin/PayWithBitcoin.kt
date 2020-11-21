package com.example.paywithbitcoin

import android.app.Application
import com.example.paywithbitcoin.di.*
import com.google.firebase.FirebaseApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PayWithBitcoin: Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PayWithBitcoin)
            modules(repositoryModule, netModule, APIModule, databaseModule)
        }

        FirebaseApp.initializeApp(applicationContext)


    }
}