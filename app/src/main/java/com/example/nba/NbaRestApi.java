package com.example.nba;

import com.example.nba.model.RestTeamsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NbaRestApi {

    @GET("teams")
    Call<RestTeamsResponse> getListTeams();
}
