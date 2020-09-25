package com.journaldev.androidmaterialtextfields;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.journaldev.androidmaterialtextfields.database.AppDatabase;
// import com.journaldev.androidmaterialtextfields.database.AppExecutors;

public class ListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // GET DATA FROM DATABASE
//        AppExecutors.getInstance().diskIO().execute(new Runnable() {
//            @Override
//            public void run() {
//                AppDatabase.UIDao().readUI();
//            }
//        });

        // Log.d("return data from UI", UI.toString());

        // DISPLAY DATA IN LISTVIEW WITH ADAPTER
    }
}