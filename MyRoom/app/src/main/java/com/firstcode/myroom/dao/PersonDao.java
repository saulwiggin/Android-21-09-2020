package com.firstcode.myroom.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.firstcode.myroom.entities.Person;
import com.firstcode.myroom.entities.Product;

import java.util.List;

/**
 * DAO: Contains the methods used for accessing the database.
 */
@Dao
public interface PersonDao {
    //CRUD
    @Insert
    void insertPerson(Person person);

    @Update
    void updatePerson(Person person);

    @Delete
    void deletePerson(Person person);

    @Query("SELECT * FROM PERSON ORDER BY ID")
    List<Person> loadAllPersons();


}
