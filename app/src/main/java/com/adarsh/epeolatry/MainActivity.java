package com.adarsh.epeolatry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] sayings = new String[6];
        sayings[0] = "\"So please, oh please, we beg, we pray, go throw your TV set away, and in " +
                "its place you can install a lovely bookshelf on the wall.\" \n – Roald Dahl " ;
        sayings[1] = " \"Reading is essential for those who seek to rise above the ordinary.\" " +
                "\n– " +"Jim Rohn ";
        sayings[2] = "\"A reader lives a thousand lives before he dies . . . The man who never " +
                "reads lives only one.\" \n– George R.R. Martin";
        sayings[3] = "\"Think before you speak. Read before you think.\" \n– Fran Lebowitz";
        sayings[4] = "\"The person who deserves most pity is a lonesome one on a rainy day who " +
                "doesn’t know how to read.\" \n– Benjamin Franklin";
        sayings[5]= "\"There is more treasure in books than in all the pirate's loot on Treasure " +
                "Island.\" \n– Walt Disney";

        Random rand = new Random();
        int x = rand.nextInt(sayings.length);
        String splash = sayings[x];
        tv = (TextView) findViewById(R.id.tv1);
        tv.setText(splash);
        startsplash();
    }

        private void startsplash(){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent it = new Intent(MainActivity.this,Login.class);
                    startActivity(it);
                    finish();
                }
            },2500);
        }
}
