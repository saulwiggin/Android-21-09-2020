package com.firstcode.myroom.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.firstcode.myroom.dao.PersonDao;
import com.firstcode.myroom.entities.Person;
import com.firstcode.myroom.entities.Product;

/**
 * https://www.javatpoint.com/singleton-design-pattern-in-java
 */
@Database(entities = {Person.class}, version= 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase sInstance;
   private static final String DATABASE_NAME= "myroom";
   private static final Object LOCK= new Object();

    public static AppDatabase getInstance(Context context){
        if(sInstance==null) {
            //All synchronized blocks synchronized on the same object can only have one thread executing inside them at a time. All other threads attempting to enter the synchronized block are blocked until
            // the thread inside the synchronized block exits the block.
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class,
                        AppDatabase.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build();

            }
        }
        return sInstance;
    }

    public abstract PersonDao personDao();

}
