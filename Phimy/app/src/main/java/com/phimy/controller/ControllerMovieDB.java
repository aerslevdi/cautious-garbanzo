package com.phimy.controller;

import android.content.Context;

import com.phimy.dao.MovieDBDao;
import com.phimy.model.MovieDB;

import java.util.List;

import Utils.InternetConnection;
import Utils.ResultListener;

public class ControllerMovieDB {
    final static public Integer KEY_SEARCH_POPULAR_MOVIE = 0;
    final static public Integer KEY_SEARCH_POPULAR_TV = 1;
    final static public Integer KEY_SEARCH_NOW_PLAYING = 2;
    MovieDBDao movieDBDao;

    public ControllerMovieDB() {
        this.movieDBDao = new MovieDBDao();
    }

    public void getMovies(final ResultListener<List<MovieDB>> listenerView, Context context){
        if (InternetConnection.isConnection(context)) {
            movieDBDao.getMovies(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> resultado) {
                    listenerView.finish(resultado);
                }
            },KEY_SEARCH_POPULAR_MOVIE);
        }
    }

    public void getTvMovies(final ResultListener<List<MovieDB>> listenerView, Context context){
        if (InternetConnection.isConnection(context)) {
            movieDBDao.getMovies(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> resultado) {
                    listenerView.finish(resultado);
                }
            }, KEY_SEARCH_POPULAR_TV);
        }
    }

    public void getNowPlaying(final ResultListener<List<MovieDB>> listenerView, Context context){
        if (InternetConnection.isConnection(context)) {
            movieDBDao.getMovies(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> resultado) {
                    listenerView.finish(resultado);
                }
            }, KEY_SEARCH_NOW_PLAYING);
        }
    }
}
