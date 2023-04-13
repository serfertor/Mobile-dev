package com.example.pr7.Domain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pr7.Data.MainRepository;

public class MAFViewModel extends ViewModel {
    MutableLiveData<String> search;

    public void setSearch(String s){
        MainRepository.create("Search", s);
    }

    public String getSearch(){
        search = new MutableLiveData<>(MainRepository.read("Search", ""));
        return search.getValue();
    }

}
