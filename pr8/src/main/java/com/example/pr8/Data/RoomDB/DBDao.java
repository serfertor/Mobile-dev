package com.example.pr8.Data.RoomDB;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface DBDao {

    @Query("SELECT * FROM dbentity")
    List<DBEntity> getAll();

    @Query("SELECT information FROM dbentity WHERE name = :name")
    Single<String> getById(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DBEntity employee);

    @Update
    void update(DBEntity employee);

    @Delete
    void delete(DBEntity employee);
}
