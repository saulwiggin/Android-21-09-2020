package com.example.paywithbitcoin.network

import com.example.paywithbitcoin.database.DatabaseBitcoin
import com.example.paywithbitcoin.domain.BTC
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface Bitcoin_API {

    @GET(API.CURRENT_PRICE_API)
    fun getCurrentPriceBitcoin(): Deferred<List<DatabaseBitcoin>>

    @GET(Coinlore.BTC)
    fun getBTCPriceCoinLore(): Deferred<List<BTC>>

}