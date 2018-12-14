package com.phimy.dao.database;


import android.arch.persistence.room.RoomDatabase;

import com.phimy.model.FavoritoDB;
import com.phimy.model.MovieDB;
import com.phimy.model.SerieDB;

@android.arch.persistence.room.Database(entities = {MovieDB.class, SerieDB.class, FavoritoDB.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    public abstract MovieDAO getMovieDbDAO();
    public abstract SerieDAO getSerieDbDAO();
    public abstract FavoritoDAO getFavoritoDbDAO();
}
