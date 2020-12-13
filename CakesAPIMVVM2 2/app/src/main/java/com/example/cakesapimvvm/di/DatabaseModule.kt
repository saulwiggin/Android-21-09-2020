package com.example.cakesapimvvm.di

import android.app.Application
import androidx.room.Room
import com.example.cakesapimvvm.database.CakeDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    fun providersDatabase(application: Application): CakeDatabase{
        return Room.databaseBuilder(application, CakeDatabase::class.java, "cakes.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    single { providersDatabase(androidApplication())
    }
}