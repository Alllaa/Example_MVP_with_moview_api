package com.example.taskmovieapi.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.taskmovieapi.Model.MovieRated;

import java.util.List;

@Dao
public interface MovieRatedDao {

    @Query("Select * FROM movierated")
    List<MovieRated> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<MovieRated> list);
}
