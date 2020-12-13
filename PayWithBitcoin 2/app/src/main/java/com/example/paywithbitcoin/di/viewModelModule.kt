package com.example.paywithbitcoin.di

import com.example.paywithbitcoin.viewmodel.CurrencyViewModel
import org.koin.dsl.module

val viewModelModule= module {
    single { CurrencyViewModel(get()) }
}