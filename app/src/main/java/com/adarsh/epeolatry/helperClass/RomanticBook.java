package com.adarsh.epeolatry.helperClass;

import com.adarsh.epeolatry.R;

import java.util.ArrayList;
import java.util.Random;

public class RomanticBook {
    private int romImg;
    private String romAuthor;

    public RomanticBook(int romImg, String romAuthor) {
        this.romImg = romImg;
        this.romAuthor = romAuthor;
    }

    public int getRomImg() {
        return romImg;
    }

    public String getRomAuthor() {
        return romAuthor;
    }

    private static int[] images = {
            R.drawable.a_long_petal_at_sea,
            R.drawable.beautiful_disaster,
            R.drawable.gone_with_wind,
            R.drawable.it_ends_with_us,
            R.drawable.outlander,
            R.drawable.pride_and_prejudice,
            R.drawable.the_hating_game,
            R.drawable.the_proposal,
            R.drawable.the_thorn_birds,
    };

    private static String[] authors = {
        "ISABEL ALLENDE",
            "JAMIE MCGUIRE",
            "MARGARET MITCHELL",
            "COLLEEN HOOVER",
            "DIANA GABALDON",
            "JANE AUSTEN",
            "SALLY THORNE",
            "JASMINE GUILLORY",
            "COLLEEN MCCULLOUGH"
    };

    public static ArrayList<RomanticBook> getBooks(int n){
        ArrayList<RomanticBook> romanticBooks = new ArrayList<>();
        Random r = new Random();

        for(int i=0; i<n; i++)
        {
            int x = r.nextInt(9);
            romanticBooks.add(new RomanticBook(images[x], authors[x]));
        }
        return romanticBooks;
    }

}
