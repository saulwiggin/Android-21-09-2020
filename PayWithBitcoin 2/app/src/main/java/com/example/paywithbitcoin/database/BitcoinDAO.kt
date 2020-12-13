package com.example.paywithbitcoin.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.paywithbitcoin.util.Converters

@Dao
interface BitcoinDAO {

    @Query("SELECT * FROM DatabaseBitcoin")
    fun getLocalDB(): LiveData<List<DatabaseBitcoin>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(prices: List<DatabaseBitcoin>)

}

@Database(entities = [DatabaseBitcoin::class], version  = 1, exportSchema = true)
@TypeConverters(Converters::class)
abstract class BitcoinDatabase: RoomDatabase(){
    abstract val bitcoinDao: BitcoinDAO
}