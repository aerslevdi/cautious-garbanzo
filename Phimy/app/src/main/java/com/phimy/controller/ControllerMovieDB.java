package com.phimy.controller;

import android.content.Context;

import com.phimy.dao.MovieDBDao;
import com.phimy.dao.database.DatabaseHelper;
import com.phimy.dao.database.FavoritoDAO;
import com.phimy.dao.database.MovieDAO;
import com.phimy.model.FavoritoDB;
import com.phimy.model.MasterMovie;
import com.phimy.model.MovieDB;
import java.util.List;
import Utils.InternetConnection;
import Utils.ResultListener;

public class ControllerMovieDB {
    final static public Integer KEY_SEARCH_POPULAR_MOVIE = 0;
    final static public Integer KEY_SEARCH_POPULAR_TV = 1;
    final static public Integer KEY_SEARCH_NOW_PLAYING = 2;
    MovieDBDao movieDBDao = new MovieDBDao();

    private static ControllerMovieDB instance;

    public static ControllerMovieDB getInstance(){
        if (instance==null){
            instance= new ControllerMovieDB();
        }
        return instance;
    }

    public void getMovies(final ResultListener<List<MovieDB>> listenerView, final Context context){
        if (InternetConnection.isConnection(context)) {
            movieDBDao.getMovies(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> resultado) {
                    MovieDAO movieDAO = DatabaseHelper
                            .getInstance(context.getApplicationContext())
                            .getMovieDbDAO();

                    movieDAO.insertarMovies(resultado);
                    listenerView.finish(resultado);
                }
            },KEY_SEARCH_POPULAR_MOVIE);

        }else {
            // PEDIAMOS A LA BASE DE DATOS
            MovieDAO movieDao = DatabaseHelper
                    .getInstance(context.getApplicationContext())
                    .getMovieDbDAO();

            List<MovieDB> movies = movieDao.buscarMovies();
            listenerView.finish(movies);
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

    public void getFavoritos(final ResultListener<List<FavoritoDB>> listenerView, Context context){
      //if (InternetConnection.isConnection(context)) {

          // PEDIAMOS A LA BASE DE DATOS
          FavoritoDAO favoritoDAO = DatabaseHelper
                  .getInstance(context.getApplicationContext())
                  .getFavoritoDbDAO();

          List<FavoritoDB> movies = favoritoDAO.buscarFavoritos();
          listenerView.finish(movies);
      //}
    }

    public void addFavoritos(Context context, MovieDB movieDB){
        movieDBDao.addFavoritos(context, movieDB);
    }

    public void removeFavoritos(Context context, MovieDB movieDB){
      movieDBDao.removeFavoritos(context, movieDB);
    }

    public void removeFavoritosDup(Context context, FavoritoDB favoritoDB ){
        movieDBDao.removeFavoritosDup(context, favoritoDB);
    }

    public List<FavoritoDB> getFavoritosDB(Context context){
        return movieDBDao.getFavoritosDB(context);
    }

    public Boolean isFavorito(MovieDB movieDB, Context context) {
        //TODO SI ESTA DENTRO DE LO
        FavoritoDAO favoritoDAO = DatabaseHelper
                .getInstance(context.getApplicationContext())
                .getFavoritoDbDAO();
        int result = favoritoDAO.isFavorito(movieDB.getId());
        return (result==0)?false:true;
    }
}
