package com.example.taskmovieapi.Rest;

import com.example.taskmovieapi.Model.MovieList;
import com.example.taskmovieapi.Model.MovieRatedList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("3/movie/now_playing")
    Call<MovieList> getMovieNow(
            @Query("api_key") String key,
            @Query("page") int page
    );

    @GET("3/movie/top_rated")
    Call<MovieRatedList> getTopMovie(
            @Query("api_key") String key,
            @Query("page") int page
    );
}
