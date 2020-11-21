package com.example.paywithbitcoin.repository

import androidx.lifecycle.LiveData
import com.example.paywithbitcoin.database.BitcoinDatabase
import com.example.paywithbitcoin.database.DatabaseBitcoin
import com.example.paywithbitcoin.network.Bitcoin_API
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class BitcoinRepository(private val Bitcoin_API: Bitcoin_API, private val database: BitcoinDatabase) {
    suspend fun refreshPrices(){
        withContext(Dispatchers.IO){
            val pricesList = Bitcoin_API.getCurrentPriceBitcoin().await()
            Timber.d("Refresh joke is called" + pricesList)

            database.bitcoinDao.insertAll(pricesList)
        }
    }

    val results: LiveData<List<DatabaseBitcoin>> = database.bitcoinDao.getLocalDB()

}