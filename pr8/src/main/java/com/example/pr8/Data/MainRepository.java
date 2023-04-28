package com.example.pr8.Data;

public class MainRepository {
    private static SearchDataSource searchDataSource = new SearchDataSource();
    private static ListsDataSource listsDataSource = new ListsDataSource();
    private static AppSpecificStorage appSpecificStorage = new AppSpecificStorage();
    private static ExternalStorage externalStorage = new ExternalStorage();
    public static void create(String name, String path, String message){
        switch (name){
            case "Search":
                searchDataSource.setSearch(message);
                break;
            case "APS":
                appSpecificStorage.writeFile(path, message);
            case "ES":
                externalStorage.writeFile(path, message);
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
                break;
            case "APS":
                answer = appSpecificStorage.readFile(p);
            case "ES":
                answer = externalStorage.readFile(p);
        }
        return answer;
    }

    public void update(){}

    public void delete(){}
}
