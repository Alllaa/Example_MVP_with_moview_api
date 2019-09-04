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
import com.example.taskmovieapi.Model.Movie;
import com.example.taskmovieapi.R;

import java.util.List;

import static com.example.taskmovieapi.Rest.GetMovies.IMAGE_BASE_URL;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<Movie> list2;

    public CustomAdapter(Context ctx, List<Movie> objects) {
        inflater = LayoutInflater.from(ctx);
        list2 = objects;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.custom_layout, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CustomAdapter.MyViewHolder myViewHolder, int i) {

        myViewHolder.textView.setText(list2.get(i).getTitle());
        String urlPoster = IMAGE_BASE_URL + list2.get(i).getPoster_path();
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
