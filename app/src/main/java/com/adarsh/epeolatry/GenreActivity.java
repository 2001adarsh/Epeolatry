package com.adarsh.epeolatry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class GenreActivity extends AppCompatActivity {

    //private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

     //   setvariables();
       // logout.setOnClickListener(this);
    }

  /*  private void setvariables(){
        logout = (Button)findViewById(R.id.logout);
    }
    @Override
    public void onClick(View view) {

        int i = view.getId();
        if(i == R.id.logout){
            FirebaseAuth.getInstance().signOut();
            Intent it = new Intent(this, Login.class);
            startActivity(it);
        }
    }

   */
}
