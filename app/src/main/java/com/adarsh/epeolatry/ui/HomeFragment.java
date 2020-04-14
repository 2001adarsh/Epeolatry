package com.adarsh.epeolatry.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adarsh.epeolatry.R;
import com.adarsh.epeolatry.adapters.RomanticAdapter;
import com.adarsh.epeolatry.helperClass.RomanticBook;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<RomanticBook> romanticBooks = RomanticBook.getBooks(100);
    RecyclerView BooksRV;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //setting ui
        BooksRV = (RecyclerView) view.findViewById(R.id.booksRV);
        BooksRV.setLayoutManager(new GridLayoutManager(getContext(), 2));
        BooksRV.setAdapter(new RomanticAdapter(romanticBooks, getContext()));

    }
}
