package com.example.taskmovieapi.Presenter;

import android.content.Context;

import com.example.taskmovieapi.Model.IMovie;
import com.example.taskmovieapi.Model.Movie;
import com.example.taskmovieapi.Model.MoviesData;
import com.example.taskmovieapi.View.IPlayNow;
import com.example.taskmovieapi.database.MovieDatabase;

import java.util.List;

public class PLayNowPresenter implements IPlayNowPresenter, IMovie.GetList {
    private IMovie moviesData;
    private IPlayNow playNow;
    private List<Movie> lMovies;


    public PLayNowPresenter(IPlayNow newPlayNow) {
        moviesData = new MoviesData();
        playNow = newPlayNow;
    }

    @Override
    public void onSendData(int x, Context context) {
        MovieDatabase movieDatabase = MovieDatabase.getInstance(context);
        moviesData.getMovies(this, x, movieDatabase);

    }


    @Override
    public void sendList(List<Movie> movies) {
        lMovies = movies;
        if (playNow != null) {
            playNow.onDataRecieved(movies);
        }
    }
}
