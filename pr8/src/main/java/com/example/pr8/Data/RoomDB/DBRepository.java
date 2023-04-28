package com.example.pr8.Data.RoomDB;

import android.app.Application;


import androidx.lifecycle.MutableLiveData;


import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class DBRepository {

    private DBDao dbDao;

    protected MutableLiveData<String> value = new MutableLiveData<>("");

    public DBRepository(Application application) {
        DBDataBase db = DBDataBase.getDatabase(application);
        dbDao = db.dbDao();
    }

    public String getById(String name){
        final String[] answer = {""};
        dbDao.getById(name).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<String>() {
                    @Override
                    public void onSuccess(String s) {
                        value.setValue(s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        value.setValue("Error");
                    }
                });
        return value.getValue();
    }

    public void insert(DBEntity dbEntity) {
        DBDataBase.databaseWriteExecutor.execute(() -> {
            dbDao.insert(dbEntity);
        });
    }
}
