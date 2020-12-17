package com.example.paywithbitcoin.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName="CoinGecko")
class CoinGeckoEntity (
    @PrimaryKey
    val id: String,
    val symbol: String,
    val name: String
)