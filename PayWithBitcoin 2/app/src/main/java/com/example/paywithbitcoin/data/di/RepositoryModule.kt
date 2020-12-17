package com.example.paywithbitcoin.data.di

import com.example.paywithbitcoin.data.database.BitcoinDatabase
import com.example.paywithbitcoin.data.network.Bitcoin_API
import com.example.paywithbitcoin.data.repository.BitcoinRepository
import org.koin.dsl.module

val repositoryModule = module {
    fun provideRepository(api: Bitcoin_API, dao: BitcoinDatabase): BitcoinRepository{
        return BitcoinRepository(api, dao)
    }

    // provide getters and setters
    single { provideRepository(get(), get())}
}