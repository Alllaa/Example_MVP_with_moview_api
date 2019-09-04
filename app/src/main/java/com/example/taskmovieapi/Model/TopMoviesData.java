package com.example.taskmovieapi.Model;

import android.util.Log;

import com.example.taskmovieapi.Rest.ApiService;
import com.example.taskmovieapi.Rest.GetMovies;
import com.example.taskmovieapi.database.MovieDatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopMoviesData implements ITopMovie  {
    List<MovieRated> movies;

    @Override
    public void getMovies2(ITopMovie.GetList2 getList, int num, MovieDatabase movieDatabase) {
        getTopMovie(getList, num, movieDatabase);
    }

    private void getTopMovie(final ITopMovie.GetList2 list, final int num, final MovieDatabase movieDatabase) {
        ApiService apiService;
        apiService = GetMovies.getClient2().create(ApiService.class);


        Call<MovieRatedList> call = apiService.getTopMovie("7306fc3ca843fa9b34280a8f0f8d7b40", num);
        call.enqueue(new Callback<MovieRatedList>() {
            @Override
            public void onResponse(Call<MovieRatedList> call, Response<MovieRatedList> response) {
                if (!response.isSuccessful()) {
                    Log.d("Code2:", "Error in response");
                    return;
                }
                Log.d("TAGTOP", "Total number of Movies fetched : " + response.body().getItems().size());

                movies = response.body().getItems();
                list.sendList2(movies);
                if(num == 1)
                {
                    movieDatabase.getMovieRatedDao().insert(movies);
                }

            }

            @Override
            public void onFailure(Call<MovieRatedList> call, Throwable t) {
                Log.d("Error2", t.getMessage());
                if (num <= 1) {
                    List<MovieRated> moviesOff = movieDatabase.getMovieRatedDao().getAll();
                    list.sendList2(moviesOff);
                }

            }
        });
    }
}
