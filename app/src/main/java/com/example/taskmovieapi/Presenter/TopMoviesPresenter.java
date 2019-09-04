package com.example.taskmovieapi.Presenter;

import android.content.Context;

import com.example.taskmovieapi.Model.ITopMovie;
import com.example.taskmovieapi.Model.MovieRated;
import com.example.taskmovieapi.Model.TopMoviesData;
import com.example.taskmovieapi.View.ITopMovies;
import com.example.taskmovieapi.database.MovieDatabase;

import java.util.List;

public class TopMoviesPresenter implements ITopMoviesPresenter, ITopMovie.GetList2 {
    private ITopMovies topMovies;
    private ITopMovie movieData;
    private List<MovieRated> lMovies;

    public TopMoviesPresenter(ITopMovies newITopMovies) {
        topMovies = newITopMovies;
        movieData = new TopMoviesData();
    }

    @Override
    public void onSendData2(int num, Context context) {
        MovieDatabase movieDatabase = MovieDatabase.getInstance(context);
        movieData.getMovies2(this, num, movieDatabase);
    }

    @Override
    public void sendList2(List<MovieRated> movies) {
        lMovies = movies;
        if (topMovies != null) {
            topMovies.onDataRecieved2(lMovies);
        }

    }


}
