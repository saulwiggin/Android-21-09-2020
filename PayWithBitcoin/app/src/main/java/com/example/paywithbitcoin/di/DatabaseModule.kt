package com.example.paywithbitcoin.di

import android.app.Application
import androidx.room.Room
import com.example.paywithbitcoin.database.BitcoinDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    fun providersDatabase(application: Application): BitcoinDatabase {
        return Room.databaseBuilder(application, BitcoinDatabase::class.java, "PayWithBitcoin.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    single { providersDatabase(androidApplication())}
}