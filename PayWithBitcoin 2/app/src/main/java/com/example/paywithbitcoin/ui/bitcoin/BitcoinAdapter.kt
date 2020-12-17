package com.example.paywithbitcoin.ui.bitcoin

import com.example.paywithbitcoin.data.database.DatabaseBitcoin

class BitcoinAdapter(coin: List<DatabaseBitcoin>) {
    private var viewmodelAdapter: BitcoinAdapter? = null

    var results: List<DatabaseBitcoin> = emptyList()
        set(value){
            field = value
        }

}