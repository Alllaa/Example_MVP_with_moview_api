package com.example.taskmovieapi.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.taskmovieapi.Adapter.CustomAdapter;
import com.example.taskmovieapi.Model.Movie;
import com.example.taskmovieapi.Presenter.PLayNowPresenter;
import com.example.taskmovieapi.R;

import java.util.ArrayList;
import java.util.List;

public class PlayNow extends Fragment implements IPlayNow {

    private RecyclerView recyclerView;
    private GridLayoutManager mGridLayoutManager;
    CustomAdapter customAdapter;
    View view;
    public int num = 1;
    PLayNowPresenter pLayNowPresenter;
    List<Movie> newLest = new ArrayList<>();
    //private MovieDatabase movieDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_now, container, false);

        // movieDatabase = MovieDatabase.getInstance(getContext());
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    Toast.makeText(getActivity(), "continue", Toast.LENGTH_SHORT).show();
                    num++;
                    pLayNowPresenter.onSendData(num, getContext());
                }
            }
        });

        pLayNowPresenter = new PLayNowPresenter(this);
        pLayNowPresenter.onSendData(num, getContext());

        customAdapter = new CustomAdapter(getContext(), newLest);
        recyclerView.setAdapter(customAdapter);
        mGridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mGridLayoutManager);


        return view;
    }

    @Override
    public void onDataRecieved(List<Movie> movies) {
        Log.d("PLAYNOW", "HAY");
        newLest.addAll(movies);
//        if(newLest.size()<=20){
//            movieDatabase.getMovieDao().insert(movies);
//            Log.d("Database","it is entered");
//        }

        customAdapter.notifyDataSetChanged();

    }

}
