package com.example.shopping_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    TextView textview2;
    TextView textview3;
    TextView textview4;
    TextView textview5;
    TextView textview6;
    TextView textview7;
    TextView textview8;
    TextView textview9;
    TextView textview10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Button button = (Button) findViewById(R.id.additembutton);
    button.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            // Do something in response to button click
            Intent intent = new Intent(this, secondActivity.class);
            startActivity(intent);

        }
    });


}