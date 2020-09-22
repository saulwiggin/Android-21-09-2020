package com.example.shopping_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity implements View.OnClickListener {

    /*
    * import buttons here
    */
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
    }

    @Override
    public void onClick(View view) {
        Intent intent=null;
        View Button2 = findViewById(R.id.button2);
        String input2 = Button2.toString();
        View Button3 = findViewById(R.id.button3);
        String input3 = Button3.toString();
        View Button4 = findViewById(R.id.button4);
        String input4 = Button2.toString();
        View Button5 = findViewById(R.id.button5);
        String input5 = Button5.toString();
        View Button6 = findViewById(R.id.button6);
        String input6 = Button6.toString();
        View Button7 = findViewById(R.id.button7);
        String input7 = Button7.toString();
        View Button8 = findViewById(R.id.button8);
        String input8 = Button8.toString();
        View Button9 = findViewById(R.id.button9);
        String input9 = Button9.toString();
        View Button10 = findViewById(R.id.button10);
        String input10 = Button10.toString();
        View Button11 = findViewById(R.id.button11);
        String input11 = Button11.toString();
        View Button12 = findViewById(R.id.button12);
        String input12 = Button12.toString();
        switch (view.getId()){
            case R.id.button2:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("ShoppingItem", input2);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("ShoppingItem", input3);
                startActivity(intent);
                break;
            case R.id.button4:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("ShoppingItem", input4);
                startActivity(intent);
                break;
            case R.id.button5:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("ShoppingItem", input5);
                startActivity(intent);
                break;
            case R.id.button6:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("ShoppingItem", input6);
                startActivity(intent);
                break;
            case R.id.button7:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("ShoppingItem", input7);
                startActivity(intent);
                break;
            case R.id.button8:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("ShoppingItem", input8);
                startActivity(intent);
                break;
            case R.id.button9:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("ShoppingItem", input9);
                startActivity(intent);
                break;
            case R.id.button10:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("ShoppingItem", input10);
                startActivity(intent);
                break;
            case R.id.button11:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("ShoppingItem", input11);
                startActivity(intent);
                break;
            case R.id.button12:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("ShoppingItem", input12);
                startActivity(intent);
                break;
        }
        if(intent!=null)
            startActivity(intent);
    }
}