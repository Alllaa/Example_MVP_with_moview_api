package com.example.taskmovieapi.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.taskmovieapi.AppClass;
import com.example.taskmovieapi.Model.Movie;
import com.example.taskmovieapi.Model.MovieRated;


@Database(entities = {MovieRated.class, Movie.class}, version = 1, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {

    public abstract MovieDao getMovieDao();

    public abstract MovieRatedDao getMovieRatedDao();

    private static MovieDatabase movieDB;

    public static MovieDatabase getInstance(Context context) {
        if (null == movieDB) {
            synchronized (MovieDatabase.class) {
                if (movieDB == null) {
                    movieDB = Room.databaseBuilder(AppClass.getObject(),
                            MovieDatabase.class, "movie.db").
                            allowMainThreadQueries().build();
                }
            }
        }
        return movieDB;
    }


}
