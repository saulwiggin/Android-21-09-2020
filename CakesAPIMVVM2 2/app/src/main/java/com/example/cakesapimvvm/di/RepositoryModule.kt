package com.example.cakesapimvvm.di

import com.example.cakesapimvvm.database.CakeDatabase
import com.example.cakesapimvvm.network.CakeShop_APIServices
import com.example.cakesapimvvm.repository.CakeRepository
import org.koin.dsl.module

val repositoryModule= module {
    fun provideRepository(api: CakeShop_APIServices, dao: CakeDatabase):CakeRepository{
        return CakeRepository(api, dao)
    }

    single { provideRepository(get(), get())
    }
}