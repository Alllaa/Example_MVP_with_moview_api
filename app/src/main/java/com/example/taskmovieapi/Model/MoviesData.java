package com.example.taskmovieapi.Model;

import android.util.Log;

import com.example.taskmovieapi.database.MovieDatabase;
import com.example.taskmovieapi.Rest.ApiService;
import com.example.taskmovieapi.Rest.GetMovies;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesData implements IMovie{

    List<Movie>movies;

    @Override
    public void getMovies(final GetList getList, int x,MovieDatabase movieDatabase) {
      getdata(getList,x,movieDatabase);
    }
    public void getdata(final IMovie.GetList list, final int x, final MovieDatabase movieDatabase)
    {
        ApiService apiService;
        apiService = GetMovies.getClient().create(ApiService.class);


        Call<MovieList> call = apiService.getMovieNow("7306fc3ca843fa9b34280a8f0f8d7b40",x);
        Log.d("XValue",Integer.toString(x));
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                if(!response.isSuccessful())
                {
                    Log.d("Code:","Error in response");
                    return;
                }
                Log.d("TAG","Total number of Movies fetched : "+response.body().getItems().size());

                movies = response.body().getItems();
                list.sendList(movies);
                if(x == 1)
                {
                    movieDatabase.getMovieDao().insert(movies);
                }

            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                Log.d("Error",t.getMessage());
                if (x<=1)
                {
                    List<Movie> moviesOff = movieDatabase.getMovieDao().getAll();
                    list.sendList(moviesOff);
                }

            }
        });
    }



}
