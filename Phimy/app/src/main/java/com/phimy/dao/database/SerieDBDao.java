package com.phimy.dao.database;

import android.content.Context;

import com.phimy.dao.DaoHelper;
import com.phimy.dao.ServiceMoviesDB;
import com.phimy.model.FavoritoDB;
import com.phimy.model.MovieDB;
import com.phimy.model.MovieDBContainer;
import com.phimy.model.SerieDB;
import com.phimy.model.SerieDBContainer;

import java.util.ArrayList;
import java.util.List;

import Utils.ResultListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SerieDBDao extends DaoHelper {
    private ServiceSeriesDB serviceSeries;
    private String api_key="5aa2e212bfa0373c59c3494bb068827f";
    Call<SerieDBContainer> call;
    List<SerieDB> favoritosSerieDBS=new ArrayList<SerieDB>();

    public SerieDBDao() {
        super("https://api.themoviedb.org/3/");
        serviceSeries = retrofit.create(ServiceSeriesDB.class);
    }

    public ServiceSeriesDB getServiceSeries() {
        return serviceSeries;
    }

    public String getApi_key() {
        return api_key;
    }

    public List<SerieDB> getFavoritosSeriesDBS(Context context) {
        SerieDAO serieDao = DatabaseHelper
                .getInstance(context.getApplicationContext())
                .getSerieDbDAO();

        List<SerieDB> movies = serieDao.buscarSeries();
        return favoritosSerieDBS;
    }

    public void getSeriesPopular(final ResultListener<List<SerieDB>> listenerDelController){
        this.call = serviceSeries.getPopularSeries(api_key);

        this.call.enqueue(new Callback<SerieDBContainer>() {
            @Override
            public void onResponse(Call<SerieDBContainer> call, Response<SerieDBContainer> response) {
                SerieDBContainer serieContainer = response.body();
                List<SerieDB> series = serieContainer.getMisSeries();
                listenerDelController.finish(series);
            }
            @Override
            public void onFailure(Call<SerieDBContainer> call, Throwable t) {
                String i= "Error";
            }
        });
    }


    public void getFavoritos(final ResultListener<List<MovieDB>> listenerDelController){
        //OJOJOJO ACA
        //listenerDelController.finish(favoritosSerieDBS);
    }

    //Administración favoritos ROOM database
    public void addFavoritos(Context context, SerieDB serieDB){
        //if (!favoritosMovieDBS.contains(movieDB)) {
        FavoritoDAO favoritoDao = DatabaseHelper
                .getInstance(context.getApplicationContext())
                .getFavoritoDbDAO();
        favoritoDao.insertarFavorito(this.convertSerieDB(serieDB));

    }

    public void removeFavoritos(Context context, SerieDB serieDB){
        //ROOM delete favorito
        FavoritoDAO favoritoDao = DatabaseHelper
                .getInstance(context.getApplicationContext())
                .getFavoritoDbDAO();
        favoritoDao.deleteFavorito(this.convertSerieDB(serieDB));

    }

    //Elimina del mismo taba de favoritos - Le viene un favorito -
    public void removeFavoritosDup(Context context, FavoritoDB favoritoDB){
        //ROOM delete favorito
        FavoritoDAO favoritoDao = DatabaseHelper
                .getInstance(context.getApplicationContext())
                .getFavoritoDbDAO();
        favoritoDao.deleteFavorito(favoritoDB);

    }

    public List<FavoritoDB> getFavoritosDB(Context context) {
        FavoritoDAO favoritoDao = DatabaseHelper
                .getInstance(context.getApplicationContext())
                .getFavoritoDbDAO();
        List<FavoritoDB> favoritos = favoritoDao.buscarFavoritos();
        return favoritos;
    }

    private FavoritoDB convertSerieDB(SerieDB serieDB){
        FavoritoDB favoritoDB= new FavoritoDB();
        favoritoDB.setId(serieDB.getId());
        favoritoDB.setTitle(serieDB.getTitle());
        favoritoDB.setPoster_path(serieDB.getPoster_path());
        favoritoDB.setVote_count(serieDB.getVote_count());
        favoritoDB.setPopularity(serieDB.getPopularity());
        favoritoDB.setOverview(serieDB.getRelease_date());
        favoritoDB.setOverview(serieDB.getOverview());

        return favoritoDB;
    }
}