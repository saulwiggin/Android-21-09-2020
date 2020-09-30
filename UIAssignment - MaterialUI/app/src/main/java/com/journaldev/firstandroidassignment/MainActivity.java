package com.journaldev.firstandroidassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.journaldev.firstandroidassignment.database.AppDatabase;
import com.journaldev.firstandroidassignment.entities.UI;
import com.journaldev.firstandroidassignment.utility.AppExecutors;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="Save Person to Database";
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeDatabase();

        TextInputLayout textInputCustomEndIcon = findViewById(R.id.name_field);
        textInputCustomEndIcon.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"End icon was clicked..",Toast.LENGTH_LONG).show();

            }
        });

        // DROPDOWN COUNTRIES LIST
        String[] COUNTRIES = new String[] {"Barbados", "Bulgaria", "Butan", "Brazil"};
        Log.v("debug", "start app with string data" + COUNTRIES);


        // AREA DROPDOWN
        Spinner areaspinner = (Spinner) findViewById(R.id.area_dropdown);

        List<String> list = new ArrayList<String>();
        list.add("+44");
        list.add("+45");
        list.add("+46");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaspinner.setAdapter(dataAdapter);

        // DROPDOWN COUNTRIES
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
                getUIData();
                Toast.makeText(getApplicationContext(),"UI Data saved",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void initializeDatabase(){
        appDatabase = AppDatabase.getInstance(getApplicationContext());
    }


    private void getUIData(){
        Log.d("DEBUG", "SAVE DATA TO DATABASE");

//        String name = "saul wiggin";
//        String phone = "07447361407";
//        String area = "+44";
//        String address = "12 St Georges Road";
//        String city = "Royal Leamington Spa";
//        String country = "UK";
//        String postcode = "CV31 3AY";
//        String email = "saulwiggin@googlemail.com";
//        String dob = "30/07/1987";

        TextInputEditText name = findViewById(R.id.name);
        TextInputEditText phone = findViewById(R.id.phone);
        Spinner area = findViewById(R.id.area_dropdown);
        TextInputEditText address = findViewById(R.id.address);
        TextInputEditText city = findViewById(R.id.city);
        Spinner country = findViewById(R.id.countries_dropdown);
        TextInputEditText postcode = findViewById(R.id.postcode);
        TextInputEditText email = findViewById(R.id.email);
        AutoCompleteTextView dob = findViewById(R.id.dob);

        final UI ui = new UI(
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

        Log.d("DEBUG", "SAVE DATA TO DATABASE" + ui.toString());
        System.out.println("Mailing a check to " + name + " " + address);

//        final UI UI= new UI(
//                name.getText().toString(),
//                phone.getText().toString(),
//                area.getSelectedItem().toString(),
//                address.getText().toString(),
//                city.getText().toString(),
//                country.getSelectedItem().toString(),
//                postcode.getText().toString(),
//                email.getText().toString(),
//                dob.getText().toString()
//        );

        AppExecutors.getInstance().diskIO().execute(new Runnable(){

            @Override
            public void run() {
                appDatabase.UIDao().insertUI(ui);
            }
        });

         nextScreenOnDataSuccess();

    }

    public void nextScreenOnDataSuccess(){
        Intent intent= new Intent(MainActivity.this, ListView.class);
        startActivity(intent);
    }

    private Context getContext() {
        return null;
    }

}
