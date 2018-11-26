package com.phimy.dao;


import com.phimy.model.MovieDB;
import com.phimy.model.MovieDBContainer;

import java.util.List;

import Utils.ResultListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDBDao extends DaoHelper {
    private ServiceMoviesDB serviceMovies;
    private String api_key="5aa2e212bfa0373c59c3494bb068827f";
    Call<MovieDBContainer> call;

    public MovieDBDao() {
        super("https://api.themoviedb.org/3/");
        //https://api.themoviedb.org/3/movie/550?api_key=5aa2e212bfa0373c59c3494bb068827f
        serviceMovies = retrofit.create(ServiceMoviesDB.class);
    }

    public void getMovies(final ResultListener<List<MovieDB>> listenerDelController, Integer search){

        switch(search) {
            case 0 :
                this.call = serviceMovies.getPopularMovies(api_key);
                break; // optional
            case 1 :
                this.call = serviceMovies.getPopularTv(api_key);
                break; // optional
            case 2 :
                this.call = serviceMovies.getNowPlaying(api_key);
                break; // optional
            // You can have any number of case statements.
            default : // Optional
                this.call = serviceMovies.getPopularMovies(api_key);
                break;
        }
        //Call<MovieDBContainer> call = serviceMovies.getPopularMovies(api_key);
        this.call.enqueue(new Callback<MovieDBContainer>() {
            @Override
            public void onResponse(Call<MovieDBContainer> call, Response<MovieDBContainer> response) {
                MovieDBContainer movieContainer = response.body();
                List<MovieDB> movies = movieContainer.getMisMovies();
                listenerDelController.finish(movies);
            }

            @Override
            public void onFailure(Call<MovieDBContainer> call, Throwable t) {
                String i= "hola";
            }
        });
    }




}