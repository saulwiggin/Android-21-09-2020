package com.firstcode.mvvm_breakinapi.di

import com.example.cakesapimvvm.viewmodel.CakeListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule= module {
    viewModel { CakeListViewModel(get()) }
}