package com.example.pr7.Domain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pr7.Data.MainRepository;

public class LVViewModel extends ViewModel {
    MutableLiveData<String> move;
    public void setMove (String key){
        String answer = MainRepository.read("Lists", key);
        if (move == null){
            this.move = new MutableLiveData<>();
        }
        move.setValue(answer);
    }
    public LiveData<String> getMove(){
        return move;
    }
}
