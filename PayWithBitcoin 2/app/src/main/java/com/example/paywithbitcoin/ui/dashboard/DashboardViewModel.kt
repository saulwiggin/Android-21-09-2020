package com.example.paywithbitcoin.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paywithbitcoin.data.repository.BitcoinRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class DashboardViewModel(val mRepo: BitcoinRepository) : ViewModel(){
    private val TAG = "Dashboard displaying Coin List"

    val results = mRepo.coinList

    init {
        refreshCoinList()
    }

    private fun refreshCoinList() {
        viewModelScope.launch {
            try {
                mRepo.getAllCryptocurrenciesList()
            } catch (e: Exception) {
                Timber.v(TAG,e.message)
            }
        }
    }
}