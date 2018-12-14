package com.phimy.dao.database;

import android.arch.persistence.room.Room;
import android.content.Context;


public class DatabaseHelper {
    private static final String DB_NAME = "database-phimy.db";
    private static Database db;

    public static Database getInstance(Context applicationContext){
        if (db == null){
            db = Room.databaseBuilder(applicationContext,
                    Database.class, DB_NAME).allowMainThreadQueries().build();
        }
        return db;
    }
}
