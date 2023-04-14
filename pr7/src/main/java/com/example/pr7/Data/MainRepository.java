package com.example.pr7.Data;

public class MainRepository {
    private static SearchDataSource searchDataSource = new SearchDataSource();
    private static ListsDataSource listsDataSource = new ListsDataSource();
    public static void create(String name, String p){
        switch (name){
            case "Search":
                searchDataSource.setSearch(p);
                break;
        }
    }

    public static String read(String name, String p){
        String answer = "";
        switch (name){
            case "Search":
                answer = searchDataSource.getSearch();
                break;
            case "Lists":
                answer = listsDataSource.getData(p);
        }
        return answer;
    }
    public void update(){}

    public void delete(){}
}
