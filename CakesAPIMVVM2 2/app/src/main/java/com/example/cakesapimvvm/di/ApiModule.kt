package com.example.cakesapimvvm.di

import com.example.cakesapimvvm.network.CakeShop_APIServices
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    fun provideUserApi(retrofit: Retrofit): CakeShop_APIServices{
        return retrofit.create(CakeShop_APIServices::class.java)
    }

    single { provideUserApi(get()) }
}