package com.firstcode.myroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firstcode.myroom.database.AppDatabase;
import com.firstcode.myroom.entities.Person;
import com.firstcode.myroom.utility.AppExecutors;
import com.firstcode.myroom.views.ListPerson;

public class MainActivity extends AppCompatActivity {
    private EditText name, email, pincode,city, phoneNumber;
    private AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initViews();
        initializeDatabase();
    }

    public void initViews(){
        name = findViewById(R.id.edit_name);
        email = findViewById(R.id.edit_email);
        pincode = findViewById(R.id.edit_pincode);
        city = findViewById(R.id.edit_city);
        phoneNumber = findViewById(R.id.edit_number);
    }


    public void initializeDatabase(){
        appDatabase = AppDatabase.getInstance(getApplicationContext());
    }


    public void savePerson(View view){
        final Person person= new Person(
                name.getText().toString(),
                email.getText().toString(),
                pincode.getText().toString(),
                city.getText().toString(),
                phoneNumber.getText().toString()
        );
        //     Caused by: java.lang.IllegalStateException: Cannot access database on the main thread since it may
        //     potentially lock the UI for a long period of time.
        /**
         * Perform work off the main thread; on separate thread
         */
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.personDao().insertPerson(person);
            }
        });
        nextScreenOnDataSuccess();
    }

    public void nextScreenOnDataSuccess(){
        Intent intent= new Intent(MainActivity.this, ListPerson.class);
                startActivity(intent);
    }
}