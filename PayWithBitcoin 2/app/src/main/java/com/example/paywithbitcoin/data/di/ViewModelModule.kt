package com.example.paywithbitcoin.data.di

import com.example.paywithbitcoin.ui.bitcoin.CurrencyViewModel
import org.koin.dsl.module

val viewModelModule= module {
    single { CurrencyViewModel(get()) }
}