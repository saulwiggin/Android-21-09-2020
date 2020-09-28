package com.journaldev.androidmaterialtextfields;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.journaldev.androidmaterialtextfields.database.AppDatabase;

import java.util.ArrayList;
// import com.journaldev.androidmaterialtextfields.database.AppExecutors;

public class ListView extends AppCompatActivity {

    public static android.widget.ListView list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // GET DATA FROM DATABASE
//        AppExecutors.getInstance().diskIO().execute(new Runnable() {
//            @Override
//            public void run() {
//                // AppDatabase.UIDao().readUI();
//            }
//        });

        Log.d("debug","return data from UI");

        // DISPLAY DATA IN LISTVIEW WITH ADAPTER

        list_view = (android.widget.ListView)findViewById(R.id.list);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Saul");
        arrayList.add("+44");
        arrayList.add("07447361407");
        arrayList.add("12 St Georges Road");
        arrayList.add("Royal Leamington Spa");
        arrayList.add("United Kingdom");
        arrayList.add("CV31 3AY");
        arrayList.add("saulwiggin@googlemail.com");
        arrayList.add("30-07-1987");

        Log.d("debug","return data from UI"+arrayList);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,                   android.R.layout.simple_list_item_1, arrayList);
        list_view.setAdapter(arrayAdapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem=(String) list_view.getItemAtPosition(position);
                Toast.makeText(ListView.this,clickedItem,Toast.LENGTH_LONG).show();
            }
        });
    }
}