package com.example.nba.model;
import java.util.List;

public class RestTeamsResponse {
    private List<Teams> data;
    //getter
    public List<Teams> getData() {
        return data;
    }
    //setter
    public void setData(List<Teams> data) {
        this.data = data;
    }
}
