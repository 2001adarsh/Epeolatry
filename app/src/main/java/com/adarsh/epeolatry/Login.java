package com.adarsh.epeolatry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
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
    private String TAG ="LoginPage";
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(this);

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
        loginet1 = (EditText) findViewById(R.id.et1);
        loginet2 = (EditText) findViewById(R.id.et2);
        login = (Button) findViewById(R.id.register);
        status = (TextView) findViewById(R.id.loginstatus);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if( i == R.id.goregister){
            Intent it = new Intent(this, Register.class);
            startActivity(it);
            finish();
        }
        if(i == R.id.register){
            loginpls();
        }
    }

    private void loginpls()
    {
        String email = loginet1.getText().toString().trim();
        String password = loginet2.getText().toString().trim();

        if(Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            //The entered email address could be taken as a e-mail address.
            //It is just in case people dont write stupid stuffs in email address field.
        }
        else{
            loginet1.setError("Enter valid Email");
            loginet1.requestFocus();
            return;  //IF input is not a valid email it will give an error.
        }
        if(password.isEmpty())
        {
            loginet2.setError("Length more than 6 digits *");
            loginet2.requestFocus();
            return;
        }
        else {

            progressDialog.setMessage("Please wait...");
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(Login.this,
                    new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
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
    }

    private void updateUI(FirebaseUser user){
        if(user!=null)
        {
            Intent it = new Intent(this, GenreActivity.class);
            startActivity(it);
            finish();
        }
    }
}
