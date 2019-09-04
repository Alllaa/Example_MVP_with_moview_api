package com.example.taskmovieapi.Model;

import com.example.taskmovieapi.database.MovieDatabase;

import java.util.List;

public interface ITopMovie {

    interface GetList2 {
        void sendList2(List<MovieRated> movies);
    }

    void getMovies2(ITopMovie.GetList2 getList, int num, MovieDatabase movieDatabase);
}
