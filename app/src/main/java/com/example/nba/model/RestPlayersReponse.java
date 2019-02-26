package com.example.nba.model;

import java.util.List;

public class RestPlayersReponse {
    private List<Players> data;
    //getter
    public List<Players> getData() {
        return data;
    }
    //setter
    public void setData(List<Players> data) {
        this.data = data;
    }
}
