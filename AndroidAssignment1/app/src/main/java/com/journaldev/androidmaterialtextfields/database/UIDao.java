package com.journaldev.androidmaterialtextfields.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.journaldev.androidmaterialtextfields.database.UI;

import java.util.List;

/**
 * DAO: Contains the methods used for accessing the database.
 */
@Dao
public interface UIDao {
    //CRUD
    @Insert
    void insertUI(UI ui);

    @Update
    void readUI(UI ui);

    @Delete
    void deleteUI(UI ui);

    @Query("SELECT * FROM UI ORDER BY ID")
    List<UI> loadAllPersons();


}
