package com.adarsh.epeolatry.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.epeolatry.R;
import com.adarsh.epeolatry.helperClass.RomanticBook;

import java.util.ArrayList;

public class RomanticAdapter extends RecyclerView.Adapter<RomanticAdapter.RomanticVH> {

    ArrayList<RomanticBook> romanticBooks;
    Context cntx;

    public RomanticAdapter(ArrayList<RomanticBook> romanticBooks, Context cntx) {
        this.romanticBooks = romanticBooks;
        this.cntx = cntx;
    }

    @NonNull
    @Override
    public RomanticVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.single_book_layout, parent, false);
        return new RomanticVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RomanticVH holder, int position) {
        RomanticBook romanticBook = romanticBooks.get(position);
        holder.RomImg.setImageResource(romanticBook.getRomImg());
        holder.Author.setText(romanticBook.getRomAuthor());
        holder.addTocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(cntx, "Book Added To Cart!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return romanticBooks.size();
    }

    public class RomanticVH extends RecyclerView.ViewHolder{

        ImageView RomImg;
        TextView Author;
        Button addTocart;

        public RomanticVH(@NonNull View itemView) {
            super(itemView);
            RomImg = itemView.findViewById(R.id.bookimg);
            Author = itemView.findViewById(R.id.author);
            addTocart = itemView.findViewById(R.id.addToCart);
        }
    }
}
