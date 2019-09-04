package com.example.taskmovieapi.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
import com.example.taskmovieapi.Model.Movie;

@Dao
public interface MovieDao {
    @Query("Select * FROM movie")
    List<Movie>getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Movie> list);
}
