package com.smiter.WebApp.controllers;

import java.util.ArrayList;
import java.util.List;

public class TableHeaders {

    private static List<String> headers = new ArrayList();
    private String[] commonHeaders = {"Title", "Genre"};

    private void addCommon(){
        headers.clear();
        for(String s : commonHeaders){
            headers.add(s);
        }
    }

    public List<String> getBookHeaders(){
        addCommon();
        headers.add(1, "Author");
        headers.add("Date Completed");
        return headers;
    }

    public List<String> getGameHeaders(){
        addCommon();
        headers.add("Date Last Played");
        return headers;
    }

    public List<String> getMovieHeaders(){
        addCommon();
        headers.add("Producer");
        headers.add("Director");
        return headers;
    }

    public List<String> getMusicHeaders(){
        addCommon();
        headers.remove(0);
        headers.add(0, "Song Title");
        headers.add(1, "Album");
        headers.add("Artist");
        return headers;
    }
}
