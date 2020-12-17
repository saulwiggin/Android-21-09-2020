package com.example.paywithbitcoin.ui.prices

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.paywithbitcoin.data.database.DatabaseBitcoin
import com.example.paywithbitcoin.data.repository.BitcoinRepository
import kotlinx.coroutines.*

class CurrencyViewModel(private val bitcoinRepository: BitcoinRepository) : ViewModel(){

    private val TAG = "Error Exception"
    private val viewModelJob = SupervisorJob()
    private val viewModelScope  = CoroutineScope(viewModelJob + Dispatchers.Main)

    val currencyResults: LiveData<List<DatabaseBitcoin>> = bitcoinRepository.results
    //val results: Flow<List<Currency>> = bitcoinRepository.pricesList

    init {
        refreshFromRepository()
        //refreshFromFlow()
    }
//
//    fun refreshFromFlow(){
//        viewModelScope.launch {
//            try {
//                val results = bitcoinRepository.getDataFromFlow()
//                Log.d(TAG, results.toString())
//            }
//            catch(networkError: Exception){
//                Log.d(TAG, networkError.toString())
//            }
//        }
//    }

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