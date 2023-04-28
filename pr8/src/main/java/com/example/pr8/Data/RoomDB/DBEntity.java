package com.example.pr8.Data.RoomDB;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DBEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "information")
    public String information;

    public DBEntity(@NonNull String name, String information) {
        this.name = name;
        this.information = information;
    }

}

