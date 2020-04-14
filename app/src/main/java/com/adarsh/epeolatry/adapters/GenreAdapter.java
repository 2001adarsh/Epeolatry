package com.adarsh.epeolatry.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.epeolatry.BottomMain;
import com.adarsh.epeolatry.helperClass.GenreBook;
import com.adarsh.epeolatry.R;
import com.adarsh.epeolatry.ui.HomeFragment;

import java.util.ArrayList;


public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.ViewHolder> {

    private Context cntx;
    ArrayList<GenreBook> lis;


    public GenreAdapter(Context context, ArrayList<GenreBook> list){
        cntx = context;
        lis = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(cntx);
        View view = layoutInflater.inflate(R.layout.genrecard, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageView imageView = holder.imageView;
        TextView name, desc;
        name = holder.genreName;
        desc = holder.genreDesc;

        imageView.setImageResource(lis.get(position).getImages());
        name.setText(lis.get(position).getGenre());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(cntx, BottomMain.class);
                cntx.startActivity(it);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView genreName, genreDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            genreName = itemView.findViewById(R.id.genreName);
        }
    }
}
