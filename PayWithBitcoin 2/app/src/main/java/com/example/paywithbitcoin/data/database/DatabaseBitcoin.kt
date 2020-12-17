package com.example.paywithbitcoin.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DatabaseBitcoin")
data class DatabaseBitcoin (
    @PrimaryKey
    @ColumnInfo(name="id") var id: Int,
    @ColumnInfo(name="disclaimer") var disclaimer: String,
    @ColumnInfo(name="chartname")  var chartname: String,
)

@Entity(tableName = "Time")
data class Time(
    @PrimaryKey
    @ColumnInfo(name="updated") var updated: String,
    @ColumnInfo(name="updatedISO") var updatedISO:String,
    @ColumnInfo(name="updateduk") var updateduk: String,
)

data class Currency (
    @PrimaryKey
    @ColumnInfo(name="id") var id: Int,
    @ColumnInfo(name="code") var code: String?,
    @ColumnInfo(name="symbol") var symbol: String?,
    @ColumnInfo(name="rate") var rate: String?,
    @ColumnInfo(name="description") var description: String,
    @ColumnInfo(name="rate_float")var rate_float: String
)
