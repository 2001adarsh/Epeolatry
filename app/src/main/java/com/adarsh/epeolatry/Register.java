package com.adarsh.epeolatry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class Register extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "EmailPassword";
    private TextView goLogin;
    private EditText et1, et2;
    private Button register;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setvariables();
        progressDialog = new ProgressDialog(this);
        mAuth= FirebaseAuth.getInstance();

        goLogin.setOnClickListener(this);
        register.setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();

        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void setvariables(){
        register = (Button) findViewById(R.id.register);
        goLogin = (TextView) findViewById(R.id.gologin);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

    }


    @Override
    public void onClick(View view) {
        int i = view.getId();

        if(i == R.id.gologin){
            Intent it = new Intent(this, Login.class);
            startActivity(it);
        }

        if( i== R.id.register){
            String email = et1.getText().toString().trim();
            String password = et2.getText().toString().trim();
            if(email.isEmpty()) {
                et1.setError("Enter email.");
                et1.requestFocus();
            }
            else if(password.isEmpty()) {
                et2.setError("Enter password.");
                et2.requestFocus();
            }
            if(email.isEmpty() || password.isEmpty())
            {
                Toast.makeText(this, "Fields are Empty.", Toast.LENGTH_SHORT).show();
            }
            else{  //Every field is filled, now creating user with email-id

                progressDialog.setMessage("Please wait...");
                progressDialog.show();

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this,
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();

                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Register.this ,"Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }
                            }
                        });
            }

        }
    }

    private void updateUI(FirebaseUser user){
        if(user==null){

        }
        else{
            Intent it = new Intent(this, GenreActivity.class);
            startActivity(it);
        }
    }

}
