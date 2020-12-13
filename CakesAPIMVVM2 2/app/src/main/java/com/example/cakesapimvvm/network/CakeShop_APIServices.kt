package com.example.cakesapimvvm.network

import com.example.cakesapimvvm.database.DatabaseCake
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface CakeShop_APIServices {
    @GET(API_Calls.CAKES_LIST_API)
    fun getCakesList(): Deferred<List<DatabaseCake>> // begin with
}