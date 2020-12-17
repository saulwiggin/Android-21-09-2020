package com.example.paywithbitcoin.data.network.model

import com.google.gson.annotations.SerializedName

class CoinGeckoEntity (

    @SerializedName("id")
    var id: String,

    @SerializedName("symbol")
    var symbol: String,

    @SerializedName("name")
    var name: String
)