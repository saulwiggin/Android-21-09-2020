package com.example.paywithbitcoin.database

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity (tableName = "BTC")
data class BTC (
    @ColumnInfo(name="id") var id: String,
    @ColumnInfo(name="symbol") var symbol: String,
    @ColumnInfo(name="name") var name: String,
    @ColumnInfo(name="nameid") var bitcoin: String,
    @ColumnInfo(name="rank") var rank: String,
    @ColumnInfo(name="price_usd") var price_usd: String,
    @ColumnInfo(name="percent_change_24h") var percent_change_24h: String,
    @ColumnInfo(name="percent_change_1h") var percent_change_1h: String,
    @ColumnInfo(name="percent_change_7d") var percent_change_7d: String,
    @ColumnInfo(name="market_cap_usd") var market_cap_usd: String,
    @ColumnInfo(name="volume24") var volume24: String,
    @ColumnInfo(name="volume24_native") var volume24_native: String,
    @ColumnInfo(name="csupply") var csupply: String,
    @ColumnInfo(name="price_btc") var price_btc: String,
    @ColumnInfo(name="tsupply") var tsupply: String,
    @ColumnInfo(name="msupply") var msupply: String,
    )