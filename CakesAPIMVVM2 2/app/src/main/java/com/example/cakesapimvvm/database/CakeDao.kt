package com.example.cakesapimvvm.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CakeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(characters : List<DatabaseCake>)


    @Query("SELECT * FROM DatabaseCake")
    fun getLocalDBCakes(): LiveData<List<DatabaseCake>>

}

@Database(entities = [DatabaseCake::class], version  = 2, exportSchema = false)
abstract class CakeDatabase: RoomDatabase(){
    abstract val cakeDao: CakeDao
}