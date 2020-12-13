package com.example.paywithbitcoin.repository

import androidx.lifecycle.LiveData
import com.example.paywithbitcoin.database.BitcoinDatabase
import com.example.paywithbitcoin.database.DatabaseBitcoin
import com.example.paywithbitcoin.network.Bitcoin_API
import kotlinx.coroutines.*

class BitcoinRepository(private val Bitcoin_API: Bitcoin_API, private val database: BitcoinDatabase) {

    private val TAG = "Currency profiles: "

    val results: LiveData<List<DatabaseBitcoin>> = database.bitcoinDao.getLocalDB()

    suspend fun refreshPrices(){
        withContext(Dispatchers.IO){
            val pricesList = Bitcoin_API.getCurrentPriceBitcoin().await()
            val bitcoinPrice = Bitcoin_API.getBTCPriceCoinLore().await()

            database.bitcoinDao.insertAll(pricesList)
        }
    }

}