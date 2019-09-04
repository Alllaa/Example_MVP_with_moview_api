package com.example.taskmovieapi.View;

import com.example.taskmovieapi.Model.MovieRated;

import java.util.List;

public interface ITopMovies {
    void onDataRecieved2(List<MovieRated> movies);
}
