package com.example.taskmovieapi.View;
import com.example.taskmovieapi.Model.Movie;

import java.util.List;

public interface IPlayNow {
    void onDataRecieved(List<Movie> movies);
}
