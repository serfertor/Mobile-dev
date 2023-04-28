package com.example.pr8.Domain;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pr8.Data.MainRepository;
import com.example.pr8.Data.RoomDB.DBEntity;
import com.example.pr8.Data.RoomDB.DBRepository;


public class WRViewModel extends AndroidViewModel {
    MutableLiveData<String> data = new MutableLiveData<>("");
    private MutableLiveData<String> ent = new MutableLiveData<>("");

    private DBRepository repo;

    private String key = "SHARED";

    public WRViewModel(@NonNull Application application) {
        super(application);
        repo = new DBRepository(application);
    }

    public void readAPS (String path){
        String answer = MainRepository.read("APS", path);
        this.data.setValue(answer);
    }

    public void writeAPS (String path, String message){
        MainRepository.create("APS", path, message);
    }

    public void readES (String path){
        String answer = MainRepository.read("ES", path);
        this.data.setValue(answer);
    }

    public void writeES (String path, String message){
        MainRepository.create("ES", path, message);
    }

    public void readSP (String key){
        SharedPreferences sharedPref = getApplication().getSharedPreferences(key, Context.MODE_PRIVATE);
        this.data.setValue(sharedPref.getString(key, ""));
    }

    public void writeSP (String key, String value){
        SharedPreferences sharedPref = getApplication().getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public LiveData<String> getEnt() { return ent; }

    public void insertDB(String name, String info) {
        DBEntity newEntity = new DBEntity(name, info);
        repo.insert(newEntity);
    }

    public void readDB(String name){
        ent.setValue(repo.getById(name));
    }

    public LiveData<String> getData(){
        return data;
    }
}
