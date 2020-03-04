package com.adarsh.epeolatry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class GenreActivity extends AppCompatActivity implements View.OnClickListener{

    private Button logout;
    RecyclerView recyclerView;
    ArrayList<GenreBook> genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

      setvariables();
      logout.setOnClickListener(this);
    }

    private void setvariables(){
        logout = (Button)findViewById(R.id.logout);

        //Array creation
        genre = new ArrayList<>();
        addingFiles();

        //REcycler View
        recyclerView = findViewById(R.id.rv);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLLM = layoutManager;
        recyclerView.setLayoutManager(rvLLM);
        GenreAdapter adapter = new GenreAdapter(this, genre);
        recyclerView.setAdapter(adapter);
    }


    private void addingFiles(){
        genre.add(new GenreBook(R.drawable.romance,"Romantic","amit dega") );
        genre.add(new GenreBook(R.drawable.horror,"Horror","amit dega") );
        genre.add(new GenreBook(R.drawable.crime,"Crime","amit dega") );
        genre.add(new GenreBook(R.drawable.scifi,"Science Fiction","amit dega") );
        genre.add(new GenreBook(R.drawable.act,"Thriller","amit dega") );
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

}
