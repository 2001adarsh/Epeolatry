package com.adarsh.epeolatry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    private TextView goLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        setvariables();
    }

    private void setvariables(){
        goLogin = (TextView) findViewById(R.id.gologin);
    }


}
