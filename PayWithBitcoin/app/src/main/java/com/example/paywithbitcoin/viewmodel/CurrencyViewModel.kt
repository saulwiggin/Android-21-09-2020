package com.example.paywithbitcoin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.paywithbitcoin.database.DatabaseBitcoin
import com.example.paywithbitcoin.repository.BitcoinRepository
import kotlinx.coroutines.*

class CurrencyViewModel(private val bitcoinRepository: BitcoinRepository) : ViewModel(){
    private val viewModelJob = SupervisorJob()
    private val viewModelScope  = CoroutineScope(viewModelJob + Dispatchers.Main)

    val characterListResults = bitcoinRepository.results

    init {
        refreshFromRepository()
    }

    fun refreshFromRepository(){
        viewModelScope.launch {
            try {
                bitcoinRepository.refreshPrices()
            }
            catch(networkError: Exception){

            }
        }
    }

    private val _navigateToSelectedProperty = MutableLiveData<DatabaseBitcoin>()
    val navigateToSelectedProperty: LiveData<DatabaseBitcoin>
        get() = _navigateToSelectedProperty

    /**
     * When the character is clicked, set the [_navigateToSelectedProperty] [MutableLiveData]
     * @param characterProperty The [Character] that was clicked on.
     */

    fun displayPropertyDetails(characterProperty: DatabaseBitcoin) {
        _navigateToSelectedProperty.value = characterProperty
    }

    /**
     * After the navigation has taken place, make sure navigateToSelectedProperty is set to null
     */
    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}