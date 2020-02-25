package com.adarsh.epeolatry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private TextView goRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setvariables();

    }

    private void setvariables(){
        goRegister = (TextView) findViewById(R.id.gologin);
    }
}
