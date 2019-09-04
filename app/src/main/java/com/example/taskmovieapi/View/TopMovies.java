package com.example.taskmovieapi.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.taskmovieapi.Adapter.CustomAdapter2;
import com.example.taskmovieapi.Model.MovieRated;
import com.example.taskmovieapi.Presenter.TopMoviesPresenter;
import com.example.taskmovieapi.R;
import com.example.taskmovieapi.database.MovieDatabase;

import java.util.ArrayList;
import java.util.List;


public class TopMovies extends Fragment implements ITopMovies {

    public int num = 1;
    CustomAdapter2 customAdapter;
    View view;
    private RecyclerView recyclerView;
    private GridLayoutManager mGridLayoutManager;
    TopMoviesPresenter topMoviesPresenter;
    List<MovieRated> newLest = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_top_movies, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_2);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    Toast.makeText(getActivity(), "continue", Toast.LENGTH_SHORT).show();
                    num++;
                    topMoviesPresenter.onSendData2(num,getContext());
                }
            }
        });

        topMoviesPresenter = new TopMoviesPresenter(this);
        topMoviesPresenter.onSendData2(num, getContext());

        customAdapter = new CustomAdapter2(getContext(), newLest);
        recyclerView.setAdapter(customAdapter);
        mGridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mGridLayoutManager);


        return view;
    }

    @Override
    public void onDataRecieved2(List<MovieRated> movies) {
        Log.d("TAG2", "Data recieved ");
        newLest.addAll(movies);
//        if(newLest.size() <= 20)
//        {
//            movieDatabase.getMovieRatedDao().insert(movies);
//            Log.d("DatabaseMR","Data has inserted");
//        }

        customAdapter.notifyDataSetChanged();

    }
}
