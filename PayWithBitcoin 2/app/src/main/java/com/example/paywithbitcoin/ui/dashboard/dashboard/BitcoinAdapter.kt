package com.example.paywithbitcoin.ui.dashboard.dashboard

import com.example.paywithbitcoin.database.DatabaseBitcoin

class BitcoinAdapter(coin: List<DatabaseBitcoin>) {
    private var viewmodelAdapter: BitcoinAdapter? = null

    var results: List<DatabaseBitcoin> = emptyList()
        set(value){
            field = value
        }

}