package com.phimy.controller;

import android.content.Context;
import com.phimy.dao.database.DatabaseHelper;
import com.phimy.dao.database.FavoritoDAO;
import com.phimy.dao.database.SerieDBDao;
import com.phimy.model.FavoritoDB;
import com.phimy.model.SerieDB;
import java.util.List;
import Utils.InternetConnection;
import Utils.ResultListener;

public class ControllerSeriesDB {
    final static public Integer KEY_SEARCH_POPULAR_SERIE = 0;
    final static public Integer KEY_SEARCH_TOP_RATED = 1;
    final static public Integer KEY_SEARCH_ON_THE_AIR = 2;

    SerieDBDao serieDBDao = new SerieDBDao();

    private static ControllerSeriesDB instance;

    public static ControllerSeriesDB getInstance(){
        if (instance==null){
            instance= new ControllerSeriesDB();
        }
        return instance;
    }

    public SerieDBDao getSerieDBDao() {
        return serieDBDao;
    }

    public void getSeriesPopular(final ResultListener<List<SerieDB>> listenerView, final Context context){
        if (InternetConnection.isConnection(context)) {
            serieDBDao.getSeriesPopular(new ResultListener<List<SerieDB>>() {
                @Override
                public void finish(List<SerieDB> resultado) {
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

    public void addFavoritos(Context context, SerieDB serieDB){
        serieDBDao.addFavoritos(context, serieDB);
    }

    public void removeFavoritos(Context context, SerieDB serieDB){
      serieDBDao.removeFavoritos(context, serieDB);
    }

    public void removeFavoritosDup(Context context, FavoritoDB favoritoDB ){
        serieDBDao.removeFavoritosDup(context, favoritoDB);
    }

    public List<FavoritoDB> getFavoritosDB(Context context){
        return serieDBDao.getFavoritosDB(context);
    }

    public Boolean isFavorito(SerieDB serieDB, Context context) {
        FavoritoDAO favoritoDAO = DatabaseHelper
                .getInstance(context.getApplicationContext())
                .getFavoritoDbDAO();
        int result = favoritoDAO.isFavorito(serieDB.getId());
        return (result==0)?false:true;
    }
}