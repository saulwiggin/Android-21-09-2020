package com.example.paywithbitcoin.di

import com.example.paywithbitcoin.database.BitcoinDatabase
import com.example.paywithbitcoin.network.API
import com.example.paywithbitcoin.network.Bitcoin_API
import com.example.paywithbitcoin.repository.BitcoinRepository
import org.koin.dsl.module
import java.lang.reflect.Array.set

val repositoryModule = module {
    fun provideRepository(api: Bitcoin_API, dao: BitcoinDatabase): BitcoinRepository{
        return BitcoinRepository(api, dao)
    }

    // provide getters and setters
    single { provideRepository(get(), get())}
}