package com.journaldev.androidmaterialtextfields;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;
import com.google.android.material.textfield.TextInputLayout;
// import com.journaldev.androidmaterialtextfields.database.AppExecutors;
import com.journaldev.androidmaterialtextfields.database.UI;
import com.journaldev.androidmaterialtextfields.database.AppDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputLayout textInputCustomEndIcon = findViewById(R.id.name);
        textInputCustomEndIcon.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"End icon was clicked..",Toast.LENGTH_LONG).show();

            }
        });

        String[] COUNTRIES = new String[] {"Barbados", "Bulgaria", "Butan", "Brazil"};

//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<>(
//                        getContext(),
//                        R.layout.dropdown_menu_item,
//                        COUNTRIES);

//        Activity view = null;
//        AutoCompleteTextView editTextFilledExposedDropdown =
//                view.findViewById(R.id.filled_exposed_dropdown);
//        editTextFilledExposedDropdown.setAdapter(adapter);

        DatePickerBuilder dpb = new DatePickerBuilder()
                .setFragmentManager(getSupportFragmentManager())
                .setStyleResId(R.style.BetterPickersDialogFragment);
        dpb.show();
    }

    private void Save(){
        getUIData();

    }

    private void nextButton(){
        // CLICK ON NEXT BUTTON TO SHOW LISTVIEW
        Button button = findViewById(R.id.saveButton);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.d("DEBUG", "back button");
                Intent intent = new Intent(getApplicationContext(), ListView.class);
                startActivity(intent);

            }
        });
    }



    private void getUIData(){
        EditText name = findViewById(R.id.name);
        EditText phone = findViewById(R.id.phone);
        EditText area = findViewById(R.id.area);
        EditText address = findViewById(R.id.Address);
        EditText city = findViewById(R.id.City);
        EditText country = findViewById(R.id.country);
        EditText postcode = findViewById(R.id.Postcode);
        EditText email = findViewById(R.id.Email);
        EditText dob = findViewById(R.id.Email);


        final UI person= new UI(
                name.getText().toString(),
                phone.getText().toString(),
                area.getText().toString(),
                address.getText().toString(),
                city.getText().toString(),
                country.getText().toString(),
                postcode.getText().toString(),
                email.getText().toString(),
                dob.getText().toString()
        );

//        AppExecutors.getInstance().diskIO().execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        AppDatabase.UIDao().insertUI(UI);
//                    }
//                });

        Log.d("return data from UI", person.toString());

    }

    private Context getContext() {
        return null;
    }
}
