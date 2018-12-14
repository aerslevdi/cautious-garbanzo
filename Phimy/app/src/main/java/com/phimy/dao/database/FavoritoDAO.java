package com.phimy.dao.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.phimy.model.FavoritoDB;

import java.util.List;

@Dao
public interface FavoritoDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertarFavorito(FavoritoDB favorito);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertarFavoritos(List<FavoritoDB> favoritos);

    @Delete
    void deleteFavorito(FavoritoDB favorito);

    @Query("SELECT * FROM Favoritos")
    List<FavoritoDB> buscarFavoritos();

    @Query("SELECT COUNT(*) from Favoritos where id= :id")
    int isFavorito(int id);
}
