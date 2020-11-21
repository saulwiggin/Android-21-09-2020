package com.example.paywithbitcoin.network

import com.example.paywithbitcoin.database.DatabaseBitcoin
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface Bitcoin_API {
    @GET(API.CURRENT_PRICE_API)
    fun getCurrentPriceBitcoin(): Deferred<DatabaseBitcoin>

}