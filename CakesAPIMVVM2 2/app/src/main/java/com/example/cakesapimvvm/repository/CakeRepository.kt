package com.example.cakesapimvvm.repository

import androidx.lifecycle.LiveData
import com.example.cakesapimvvm.database.CakeDatabase
import com.example.cakesapimvvm.database.DatabaseCake
import com.example.cakesapimvvm.network.CakeShop_APIServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CakeRepository(private val backeryApiservices: CakeShop_APIServices,
                     private val database: CakeDatabase)
{
    suspend fun refreshCakes(){
        withContext(Dispatchers.IO){
            val cakesList= backeryApiservices.getCakesList().await()
            database.cakeDao.insertAll(cakesList)
        }
    }

    val results: LiveData<List<DatabaseCake>> = database.cakeDao.getLocalDBCakes()
}