package com.example.greendao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.greendao.entities.User;
import com.example.greendao.ui.main.MainFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private static final String TAG ="GREENDAO IMPLEMENTATION";
    private static final String TAG2 ="UI FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MainFragment fragment = new MainFragment();
        fragmentTransaction.add(R.id.container, fragment);
        fragmentTransaction.commit();

    }

    public void openRecyclerView(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        RecyclerFragment fragment = new RecyclerFragment();
        fragmentTransaction.add(R.id.container, fragment);
        fragmentTransaction.commit();
    }

}