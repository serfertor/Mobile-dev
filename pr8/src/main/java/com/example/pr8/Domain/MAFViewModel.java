package com.example.pr8.Domain;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pr8.Data.MainRepository;

public class MAFViewModel extends ViewModel {
    MutableLiveData<String> search;

    public void setSearch(String s){
        MainRepository.create("Search", "", s);
    }

    public String getSearch(){
        search = new MutableLiveData<>(MainRepository.read("Search", ""));
        return search.getValue();
    }
}
