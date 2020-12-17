package com.example.paywithbitcoin.di

import com.example.paywithbitcoin.ui.dashboard.prices.CurrencyViewModel
import org.koin.dsl.module

val viewModelModule= module {
    single { CurrencyViewModel(get()) }
}