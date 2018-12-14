package com.phimy.dao.database;

import com.phimy.model.MovieDBContainer;
import com.phimy.model.SerieDBContainer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceSeriesDB {
    @GET("tv/popular")
    Call<SerieDBContainer> getPopularSeries(@Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Call<SerieDBContainer> getNowPlaying(@Query("api_key") String apiKey);

    @GET("movie/upcoming")
    Call<SerieDBContainer> getUpComing(@Query("api_key") String apiKey);

    @GET("search/movie")
    Call<SerieDBContainer> getSearchMovie(@Query("api_key") String apiKey, @Query("query") String name);
}
