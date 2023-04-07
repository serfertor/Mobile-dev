package com.example.pr7.Data;

import java.util.ArrayList;

public class SearchDataSource {
    private ArrayList<String> searchHistory = new ArrayList<>();

    public void setSearch(String s){
        searchHistory.add(s);
    }

    public String getSearch(){
        if (searchHistory.isEmpty()){
            return "Error";
        } else {
            return searchHistory.get(searchHistory.size() - 1);
        }
    }
}
