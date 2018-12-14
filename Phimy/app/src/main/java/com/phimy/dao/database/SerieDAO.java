package com.phimy.dao.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.phimy.model.MovieDB;
import com.phimy.model.SerieDB;

import java.util.List;

@Dao
public interface SerieDAO {
    @Insert
    long insertarSerie(SerieDB serie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertarSeries(List<SerieDB> series);

    @Query("SELECT * FROM Series")
    List<SerieDB> buscarSeries();
}
