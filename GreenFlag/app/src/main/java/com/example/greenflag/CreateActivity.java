package com.example.greenflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        ImageView image = findViewById(R.id.backArrow);

        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("DEBUG", "back button");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

        // CREATE VALIDATION
        ImageView nextButton = findViewById(R.id.Nextbutton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("DEBUG", "next button");
                EditText email = findViewById(R.id.emailedittext);
                TextView validation = findViewById(R.id.emailValidaitionMessage);
                ImageView errorCross = findViewById(R.id.buttonCross);
                ImageView emailtick = findViewById(R.id.emailtick);
                EditText password = findViewById(R.id.password);
                EditText passwordrepeat = findViewById(R.id.passwordrepeat);
                ImageView passwordtick = findViewById(R.id.passwordtick);
                ImageView repeattick = findViewById(R.id.repeattick);

                String text=email.getText().toString();
                Log.v("DEBUG", "email validation" + text);
                validation.setVisibility(View.INVISIBLE);
                errorCross.setVisibility(View.INVISIBLE);
                emailtick.setVisibility(View.INVISIBLE);
                repeattick.setVisibility(View.INVISIBLE);
                passwordtick.setVisibility(View.INVISIBLE);
                email.setBackground(null);
                password.setBackground(null);
                passwordrepeat.setBackground(null);
                if(text.equals("saulwiggin@googlemail.com")){
                    Log.d("DEBUG", "email validated");
                    validation.setVisibility(View.VISIBLE);
                    errorCross.setVisibility(View.VISIBLE);
                } else {
                    // PASSES EMAIL VALIDATION
                    ShapeDrawable shape = new ShapeDrawable(new RectShape());
                    shape.getPaint().setColor(Color.GREEN);
                    shape.getPaint().setStyle(Paint.Style.STROKE);
                    shape.getPaint().setStrokeWidth(3);
                    email.setBackground(shape);
                    emailtick.setVisibility(View.VISIBLE);
                }
                String passwordtext=password.getText().toString();
                String repeattext=passwordrepeat.getText().toString();
                Log.v("DEBUG", "password validation" + passwordtext + repeattext);
                if(passwordtext.equals(repeattext)){
                    ShapeDrawable shape = new ShapeDrawable(new RectShape());
                    shape.getPaint().setColor(Color.GREEN);
                    shape.getPaint().setStyle(Paint.Style.STROKE);
                    shape.getPaint().setStrokeWidth(3);
                    password.setBackground(shape);
                    passwordrepeat.setBackground(shape);
                    repeattick.setVisibility(View.VISIBLE);
                    passwordtick.setVisibility(View.VISIBLE);
                } else {
                    Log.d("DEBUG", "password validation failed");
                    validation.setVisibility(View.VISIBLE);
                    errorCross.setVisibility(View.VISIBLE);
                    ShapeDrawable shape = new ShapeDrawable(new RectShape());
                    shape.getPaint().setColor(Color.RED);
                    shape.getPaint().setStyle(Paint.Style.STROKE);
                    shape.getPaint().setStrokeWidth(3);
                    password.setBackground(shape);
                    passwordrepeat.setBackground(shape);
                }
            }
        });
    }
}