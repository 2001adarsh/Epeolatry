package com.adarsh.epeolatry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private TextView goRegister,status;
    private EditText loginet1, loginet2;
    private Button login;
    private FirebaseAuth mAuth;
    private String email, password;
    private String TAG ="LoginPage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        setvariables();
        goRegister.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        updateUI(user);
    }

    private void setvariables(){
        goRegister = (TextView) findViewById(R.id.goregister);
        loginet1 = (EditText) findViewById(R.id.loginet1);
        loginet2 = (EditText) findViewById(R.id.loginet2);
        login = (Button) findViewById(R.id.login);
        status = (TextView) findViewById(R.id.loginstatus);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if( i == R.id.goregister){
            Intent it = new Intent(this, Register.class);
            startActivity(it);
        }
        if(i == R.id.login){
            email = loginet1.getText().toString();
            password = loginet2.getText().toString();
            if(email.isEmpty()){
                loginet1.setError("Cannot be Empty");
                loginet1.requestFocus();
            }
            else if(password.isEmpty())
            {
                loginet2.setError("Cannot be Empty");
                loginet2.requestFocus();
            }
            else if(email.isEmpty() || password.isEmpty())
            {
                Toast.makeText(this, "Fields cannot be empty!", Toast.LENGTH_SHORT).show();
            }
            else
            { loginpls(); }
        }
    }

    private void loginpls()
    {
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success");
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                    Toast.makeText(Login.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
                if (!task.isSuccessful()) {
                    status.setText("Invalid Credentials.");
                }
            }
        });
    }

    private void updateUI(FirebaseUser user){
        if(user==null)
        {

        }
        else{
            Intent it = new Intent(this, HomeActivity.class);
            startActivity(it);
        }
    }
}
