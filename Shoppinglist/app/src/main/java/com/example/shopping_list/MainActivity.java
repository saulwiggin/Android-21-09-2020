package com.example.shopping_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

    private EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLocationEditText = findViewById(R.id.plain_text_input);

    }

    @Override
    public void onClick(View view) {
        Intent intent=null;
        View addButton = findViewById(R.id.additembutton);

        switch (view.getId()){
            case R.id.additembutton:
                /**
                 * Action
                 * Data
                 */
                intent = new Intent(this, secondActivity.class);
                startActivity(intent);
                break;
        }
        if(intent!=null)
            startActivity(intent);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String strEditText = data.getStringExtra("editTextValue");
            }
        }
    }


    public void Locate(View view) {
        // GET THE STRING FROM THE EDIT TEXT FIELD
        String loc = mLocationEditText.getText().toString();

        // PARSE THE GOOGLE LOCATION STRING INTO AN INTENT
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

}