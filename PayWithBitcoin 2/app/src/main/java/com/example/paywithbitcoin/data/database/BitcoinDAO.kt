package com.example.paywithbitcoin.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.paywithbitcoin.data.domain.model.ShitCoin
import com.example.paywithbitcoin.data.network.model.ShitCoinDTO
import com.example.paywithbitcoin.data.util.Converters

@Dao
interface BitcoinDAO {

    @Query("SELECT * FROM DatabaseBitcoin")
    fun getLocalDB(): LiveData<List<DatabaseBitcoin>>

    @Query("SELECT * FROM CoinGecko")
    fun getShitCoinList(): LiveData<List<CoinGeckoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(prices: List<DatabaseBitcoin>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCoinsList(coinsList: List<ShitCoin>)

}

@Database(entities = [DatabaseBitcoin::class], version  = 1, exportSchema = true)
@TypeConverters(Converters::class)
abstract class BitcoinDatabase: RoomDatabase(){
    abstract val bitcoinDao: BitcoinDAO
}