package com.example.paywithbitcoin.ui.bitcoin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.paywithbitcoin.data.database.DatabaseBitcoin
import com.example.paywithbitcoin.data.domain.BTC
import com.example.paywithbitcoin.data.domain.model.ShitCoin
import com.example.paywithbitcoin.data.repository.BitcoinRepository
import kotlinx.coroutines.*

class CurrencyViewModel(private val bitcoinRepository: BitcoinRepository) : ViewModel(){

    private val TAG = "Error Exception"
    private val viewModelJob = SupervisorJob()
    private val viewModelScope  = CoroutineScope(viewModelJob + Dispatchers.Main)

    val currencyResults: LiveData<BTC> = bitcoinRepository.BTCInformation

    init {
        refreshFromRepository()
    }


    // Replace Live data with Flow
    fun refreshFromRepository(){
        viewModelScope.launch {
            try {
                bitcoinRepository.refreshPrices()
            }
            catch(networkError: Exception){
                Log.d(TAG, networkError.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}