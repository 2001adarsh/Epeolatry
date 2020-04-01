package com.adarsh.epeolatry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class GenreActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener{

    RecyclerView recyclerView;
    ArrayList<GenreBook> genre;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      setvariables();

      navigationalDrawer();
    }

    private void setvariables(){

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

        //Navigational Drawer
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

    }


    private void addingFiles(){
        genre.add(new GenreBook(R.drawable.romance,"Romantic","amit dega") );
        genre.add(new GenreBook(R.drawable.horror,"Horror","amit dega") );
        genre.add(new GenreBook(R.drawable.crime,"Crime","amit dega") );
        genre.add(new GenreBook(R.drawable.scifi,"Science Fiction","amit dega") );
        genre.add(new GenreBook(R.drawable.act,"Thriller","amit dega") );
    }

    private void navigationalDrawer(){

        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }


    @Override
    public void onClick(View view) {

        int i = view.getId();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile_menu:

                break;
            case R.id.settings_menu:

                break;
            case R.id.signOut_menu:
                FirebaseAuth.getInstance().signOut();
                Intent it = new Intent(this, Login.class);
                startActivity(it);
                finish();
                break;
            case R.id.cart_menu:

                break;
            case R.id.whishlist_menu:

                break;
            case R.id.history_menu:

                break;
            case R.id.chats_menu:

                break;
        }
        return true;

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}
