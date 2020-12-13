package com.example.cakesapimvvm.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Saving the backend API response locally in room database: offline mode
 * Save the API response in room and always read from local database
 */
@Entity
data class DatabaseCake(
    @PrimaryKey
    var title: String,
    var desc: String,
    var image: String

)
