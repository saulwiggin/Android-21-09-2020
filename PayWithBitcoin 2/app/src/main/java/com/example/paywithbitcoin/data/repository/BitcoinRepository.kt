package com.example.paywithbitcoin.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.paywithbitcoin.data.database.BitcoinDatabase
import com.example.paywithbitcoin.data.database.CoinGeckoEntity
import com.example.paywithbitcoin.data.database.DatabaseBitcoin
import com.example.paywithbitcoin.data.domain.model.ShitCoin
import com.example.paywithbitcoin.data.network.Bitcoin_API
import com.example.paywithbitcoin.data.network.CoinGeckoMapper
import kotlinx.coroutines.*
import timber.log.Timber

class BitcoinRepository(private val Bitcoin_API: Bitcoin_API, private val database: BitcoinDatabase) {

    private val TAG = "Currency profiles: "

    private val _coinList = MutableLiveData<List<ShitCoin>>()
    val coinList: LiveData<List<ShitCoin>> = _coinList

    val dao = database.bitcoinDao
    val results: LiveData<List<DatabaseBitcoin>> = database.bitcoinDao.getLocalDB()

    suspend fun refreshPrices(){
        withContext(Dispatchers.IO){
            val pricesList = Bitcoin_API.getCurrentPriceBitcoin().await()
            val bitcoinPrice = Bitcoin_API.getBTCPriceCoinLore().await()
            val coinList = Bitcoin_API.getListOfShitCoins().await()

            Timber.log(1, coinList.toString())

            database.bitcoinDao.insertAll(pricesList)
        }
    }

    suspend fun persistCoinList(coinNetworkList: List<ShitCoin>){
        GlobalScope.launch(Dispatchers.IO){
            val coinList = CoinGeckoMapper().toEntityList(coinNetworkList)
            dao.insertCoinsList(coinNetworkList)
        }
    }

    suspend fun getAllCryptocurrenciesList(){

        val mapper = CoinGeckoMapper()
        val ShitCoin = ShitCoin("01coin", "zoc", "01coin")

        val networkEntity: CoinGeckoEntity = mapper.mapToEntity(ShitCoin)
        val r = mapper.mapFromEntity(networkEntity)

        dao.getShitCoinList().observeForever( {
            _coinList.value = CoinGeckoMapper().toModelList(it)
        })
    }

}