package com.example.paywithbitcoin.data.network

import com.example.paywithbitcoin.data.database.CoinGeckoEntity
import com.example.paywithbitcoin.data.domain.model.ShitCoin
import com.example.paywithbitcoin.data.network.model.ShitCoinDTO
import com.example.paywithbitcoin.data.util.EntityMapper

class CoinGeckoMapper: EntityMapper<CoinGeckoEntity, ShitCoin> {

    override fun mapToEntity(domainMode: ShitCoin): CoinGeckoEntity {
        TODO("Not required to be implemented")
    }

    override fun mapFromEntity(entity: CoinGeckoEntity): ShitCoin {
        return ShitCoin(
            id = entity.id,
            symbol = entity.symbol,
            name = entity.name
        )
    }

    fun fromEntityList(initial: List<CoinGeckoEntity>): List<ShitCoin> {
        return initial.map { mapFromEntity(it) }
    }

    fun toEntityList(initial: List<ShitCoin>): List<CoinGeckoEntity>{
        return initial.map { mapToEntity(it) }
    }

    fun toModelList(initial: List<CoinGeckoEntity>): List<ShitCoin>{
        return initial.map {
            mapFromEntity(it)
        }
    }
}