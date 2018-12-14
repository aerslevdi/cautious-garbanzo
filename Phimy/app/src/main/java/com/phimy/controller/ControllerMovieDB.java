package com.phimy.controller;

import android.content.Context;

import com.phimy.dao.MovieDBDao;
import com.phimy.dao.ServiceMoviesDB;
import com.phimy.dao.database.DatabaseHelper;
import com.phimy.dao.database.FavoritoDAO;
import com.phimy.dao.database.MovieDAO;
import com.phimy.model.Cast;
import com.phimy.model.FavoritoDB;
import com.phimy.model.MasterMovie;
import com.phimy.model.MovieDB;
import com.phimy.model.MovieDBContainer;
import com.phimy.model.VideoDB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Utils.InternetConnection;
import Utils.ResultListener;
import retrofit2.Response;

public class ControllerMovieDB {
    final static public Integer KEY_SEARCH_POPULAR_MOVIE = 0;
    final static public Integer KEY_SEARCH_POPULAR_TV = 1;
    final static public Integer KEY_SEARCH_NOW_PLAYING = 2;
    final static public Integer KEY_SEARCH_NEXT_COMMING = 3;

    MovieDBDao movieDBDao = new MovieDBDao();

    private static ControllerMovieDB instance;

    public static ControllerMovieDB getInstance(){
        if (instance==null){
            instance= new ControllerMovieDB();
        }
        return instance;
    }

    public MovieDBDao getMovieDBDao() {
        return movieDBDao;
    }


    public void getMovies(final ResultListener<List<MovieDB>> listenerView, final Context context){
        if (InternetConnection.isConnection(context)) {
            movieDBDao.getMoviesPopular(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> resultado) {
            listenerView.finish(resultado);
                }
            });

        }else {
            // PEDIAMOS A LA BASE DE DATOS
            MovieDAO movieDao = DatabaseHelper
                    .getInstance(context.getApplicationContext())
                    .getMovieDbDAO();

            List<MovieDB> movies = movieDao.buscarMovies();
            listenerView.finish(movies);
        }
    }

    public void getNowPlaying(final ResultListener<List<MovieDB>> listenerView, Context context){
        if (InternetConnection.isConnection(context)) {
            movieDBDao.getNowPlaying(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> resultado) {
                    listenerView.finish(resultado);
                }
            });
        }
    }

    public List<MovieDB> getSearchMovies(String query){
        List<MovieDB> listmovies= new ArrayList<>();
        ServiceMoviesDB serv=this.getMovieDBDao().getServiceMovies();
        try {
            Response<MovieDBContainer> repos = serv.getSearchMovie(this.getMovieDBDao().getApi_key(), query).execute();
            MovieDBContainer movies= repos.body();
            listmovies = movies.getMisMovies();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listmovies;
    }

    public void getTvMovies(final ResultListener<List<MovieDB>> listenerView, Context context){
        if (InternetConnection.isConnection(context)) {
            movieDBDao.getTvPopular(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> resultado) {
                    listenerView.finish(resultado);
                }
            });
        }
    }

    public void getUpComing(final ResultListener<List<MovieDB>> listenerView, Context context){
        if (InternetConnection.isConnection(context)) {
            movieDBDao.getUpComing(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> resultado) {
                    listenerView.finish(resultado);
                }
            });
        }
    }

    public void getFavoritos(final ResultListener<List<FavoritoDB>> listenerView, Context context){
          // PEDIAMOS A LA BASE DE DATOS
          FavoritoDAO favoritoDAO = DatabaseHelper
                  .getInstance(context.getApplicationContext())
                  .getFavoritoDbDAO();

          List<FavoritoDB> movies = favoritoDAO.buscarFavoritos();
          listenerView.finish(movies);
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
        FavoritoDAO favoritoDAO = DatabaseHelper
                .getInstance(context.getApplicationContext())
                .getFavoritoDbDAO();
        int result = favoritoDAO.isFavorito(movieDB.getId());
        return (result==0)?false:true;
    }

    // CONTROLLER GETCAST START
    public void getCast(Context context, final ResultListener<List<Cast>>viewListener, Integer movie_id){
        if (InternetConnection.isConnection(context)){
            movieDBDao.getCast(new ResultListener<List<Cast>>() {
                @Override
                public void finish(List<Cast> resultado) {
                    viewListener.finish(resultado);

                }
            }, movie_id);
        }
    }
    //CONTROLLER GETCAST END

    //CONTROLLER GETVIDEO START
    public void getVideoDB (Context context, final ResultListener<VideoDB> resultListener, Integer movie_id){
        if (InternetConnection.isConnection(context)){
            movieDBDao.getVideo(new ResultListener<List<VideoDB>>() {
                @Override
                public void finish(List<VideoDB> resultado) {

                    resultListener.finish(resultado.get(0));
                }
            }, movie_id);
        }
    }

    //CONTROLLER GETVIDEO END
}
