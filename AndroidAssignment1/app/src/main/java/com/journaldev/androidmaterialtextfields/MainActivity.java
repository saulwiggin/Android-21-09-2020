package com.journaldev.androidmaterialtextfields;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;
import com.google.android.material.textfield.TextInputLayout;
// import com.journaldev.androidmaterialtextfields.database.AppExecutors;
import com.journaldev.androidmaterialtextfields.database.UI;

import java.util.ArrayList;
import java.util.List;

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

        // DROPDOWN COUNTRIES LIST

        String[] COUNTRIES = new String[] {"Barbados", "Bulgaria", "Butan", "Brazil"};
        Log.v("debug", "start app with string data" + COUNTRIES);


        // areacode dropdown
        Spinner areaspinner = (Spinner) findViewById(R.id.area_dropdown);

        List<String> list = new ArrayList<String>();
        list.add("+44");
        list.add("+45");
        list.add("+46");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaspinner.setAdapter(dataAdapter);

        // DROPDOWN COUTNRIES
        Spinner countries = (Spinner) findViewById(R.id.countries_dropdown);

        List<String> countrieslist = new ArrayList<String>();
        countrieslist.add("UK");
        countrieslist.add("Barbados");
        countrieslist.add("Bulgaria");
        countrieslist.add("Butan");
        countrieslist.add("Brazil");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, countrieslist);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countries.setAdapter(dataAdapter2);

        //datepicker
        DatePickerBuilder dpb = new DatePickerBuilder()
                .setFragmentManager(getSupportFragmentManager())
                .setStyleResId(R.style.BetterPickersDialogFragment);
        dpb.show();

        // BUTTON CLICK
        Button button = (Button) findViewById(R.id.nextButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               Log.d("DEBUG", "BUTTON HAS BEEN CLICKED");
                Intent intent = new Intent(getApplicationContext(), ListView.class);
                startActivity(intent);
            }
        });

        // BUTTON CLICK
        Button savebutton = (Button) findViewById(R.id.saveButton);
        savebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("DEBUG", "SAVE DATA TO DATABASE");
                // getUIData();
                Toast.makeText(getApplicationContext(),"UI Data saved",Toast.LENGTH_LONG).show();
            }
        });
    }


    private void getUIData(){
        EditText name = findViewById(R.id.name);
        EditText phone = findViewById(R.id.phone);
        Spinner area = findViewById(R.id.area_dropdown);
        EditText address = findViewById(R.id.Address);
        EditText city = findViewById(R.id.City);
        Spinner country = findViewById(R.id.countries_dropdown);
        EditText postcode = findViewById(R.id.Postcode);
        EditText email = findViewById(R.id.Email);
        EditText dob = findViewById(R.id.dob);

        final UI UI= new UI(
                name.getText().toString(),
                phone.getText().toString(),
                area.getSelectedItem().toString(),
                address.getText().toString(),
                city.getText().toString(),
                country.getSelectedItem().toString(),
                postcode.getText().toString(),
                email.getText().toString(),
                dob.getText().toString()
        );

        Log.d("data from UI", UI.toString());

        //        AppExecutors.getInstance().diskIO().execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        AppDatabase.UIDao().insertUI(UI);
//                    }
//                });
    }

    private Context getContext() {
        return null;
    }


}
