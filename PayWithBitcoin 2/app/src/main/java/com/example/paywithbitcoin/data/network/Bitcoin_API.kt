package com.example.paywithbitcoin.data.network

import com.example.paywithbitcoin.data.database.DatabaseBitcoin
import com.example.paywithbitcoin.data.domain.BTC
import com.example.paywithbitcoin.data.network.constants.Coinlore
import com.example.paywithbitcoin.data.network.model.ShitCoinDTO
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface Bitcoin_API {

    @GET(API.CURRENT_PRICE_API)
    fun getCurrentPriceBitcoin(): Deferred<List<DatabaseBitcoin>>

    @GET(Coinlore.BTC)
    fun getBTCPriceCoinLore(): Deferred<List<BTC>>

    @GET(API.COIN_LIST)
    fun getListOfShitCoins(): Deferred<List<ShitCoinDTO>>
}