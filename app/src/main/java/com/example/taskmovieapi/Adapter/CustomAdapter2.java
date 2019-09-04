package com.example.taskmovieapi.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.taskmovieapi.Model.MovieRated;
import com.example.taskmovieapi.R;

import java.util.List;

import static com.example.taskmovieapi.Rest.GetMovies.IMAGE_BASE_URL2;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.MyViewHolder> {

    private LayoutInflater inflater;
    List<MovieRated> list2;

    public CustomAdapter2(Context ctx, List<MovieRated> objects) {
        inflater = LayoutInflater.from(ctx);
        list2 = objects;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.custom_layout, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CustomAdapter2.MyViewHolder myViewHolder, int i) {

        myViewHolder.textView.setText(list2.get(i).getTitle());
        String urlPoster = IMAGE_BASE_URL2 + list2.get(i).getPoster_path();
        Glide.with(myViewHolder.imageView.getContext()).load(urlPoster).into(myViewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt);
            imageView = itemView.findViewById(R.id.img);
        }
    }
}


