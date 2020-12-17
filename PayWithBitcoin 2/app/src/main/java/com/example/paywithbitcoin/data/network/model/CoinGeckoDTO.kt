package com.example.paywithbitcoin.data.network.model

import com.google.gson.annotations.SerializedName

data class ShitCoinDTO(

    @SerializedName("id")
    var id: String,

    @SerializedName("symbol")
    var symbol: String,

    @SerializedName("name")
    var name: String
)