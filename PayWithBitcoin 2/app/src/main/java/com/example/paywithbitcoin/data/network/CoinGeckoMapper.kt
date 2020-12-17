package com.example.paywithbitcoin.data.network

import com.example.paywithbitcoin.data.domain.ShitCoin
import com.example.paywithbitcoin.data.network.model.CoinGeckoEntity
import com.example.paywithbitcoin.data.util.EntityMapper

class CoinGeckoMapper: EntityMapper<CoinGeckoEntity, ShitCoin> {

    override fun mapToEntity(domainMode: ShitCoin): CoinGeckoEntity {
        TODO("Not yet implemented")
    }

    override fun mapFromEntity(entity: CoinGeckoEntity): ShitCoin {
        return ShitCoin(
            id = entity.id,
            symbol = entity.symbol,
            name = entity.name
        )
    }
}