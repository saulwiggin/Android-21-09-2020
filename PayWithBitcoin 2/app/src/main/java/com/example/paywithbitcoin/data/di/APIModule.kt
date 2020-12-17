package com.example.paywithbitcoin.data.di

import com.example.paywithbitcoin.data.network.Bitcoin_API
import org.koin.dsl.module
import retrofit2.Retrofit

val APIModule = module {
    fun provideApi(retrofit: Retrofit): Bitcoin_API{
        return retrofit.create(Bitcoin_API::class.java)
    }

    single { provideApi(get()) }
}