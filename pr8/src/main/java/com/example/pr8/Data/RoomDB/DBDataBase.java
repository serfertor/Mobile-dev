package com.example.pr8.Data.RoomDB;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {DBEntity.class}, version = 1)
public abstract class DBDataBase extends RoomDatabase {
    public abstract DBDao dbDao();
    private static volatile DBDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 2;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static DBDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DBDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DBDataBase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
