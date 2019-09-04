package com.example.taskmovieapi.Model;

import com.example.taskmovieapi.database.MovieDatabase;

import java.util.List;

public interface IMovie {

    interface GetList{
        void sendList(List<Movie>movies);
    }
    void getMovies(IMovie.GetList getList, int num,MovieDatabase movieDatabase);
}
