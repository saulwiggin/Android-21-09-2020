package com.journaldev.firstandroidassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.journaldev.firstandroidassignment.database.AppDatabase;
import com.journaldev.firstandroidassignment.entities.UI;
import com.journaldev.firstandroidassignment.utility.AppExecutors;

import java.util.ArrayList;
import java.util.List;
// import com.journaldev.androidmaterialtextfields.utility.AppExecutors;

public class ListView extends AppCompatActivity {

    public static android.widget.ListView list_view;
    public final String TAG="DEBUG";
    private AppDatabase appDatabase;
    private List<UI> UIList;
    RecyclerViewAdapter UIAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // REPLACE LIST VIEW WITH RECYCLER VIEW

        // android.widget.ListView recycler_view = (android.widget.ListView) findViewById(R.id.recyclerView);
        Log.d("debug","recycler view - CALL ADAPTER");

        initializeDatabase();
        initRecyclerView();
        initData();
    }

    public void initializeDatabase(){
        appDatabase = AppDatabase.getInstance(getApplicationContext());
    }

    public void initData(){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {

            @Override
            public void run() {
                UIList = appDatabase.UIDao().loadAllPersons();
                for(int i=0; i< UIList.size(); i++){
                    Log.i("TABLE","Person Table values" + UIList.get(i).getName());
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // recyclerview
                        UIAdapter.setPersonsList(UIList);
                    }
                });

            }
        });
    }

    public void initRecyclerView(){

        Log.d(TAG, "initRecyclerView: init recyclerview");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);

    }
}