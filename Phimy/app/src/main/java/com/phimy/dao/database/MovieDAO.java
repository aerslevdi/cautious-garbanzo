package com.phimy.dao.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.phimy.model.MovieDB;
import java.util.List;

@Dao
public interface MovieDAO {
    @Insert
    long insertarMovie(MovieDB movie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertarMovies(List<MovieDB> movies);

    @Query("SELECT * FROM Movies")
    List<MovieDB> buscarMovies();
}
