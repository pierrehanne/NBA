package com.example.nba;

import com.example.nba.model.RestTeamsResponse;
import com.example.nba.model.Teams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainController {

    private final MainActivity mainActivity;
    private static MainController instance = null;

    public static MainController getInstance(MainActivity mainActivity){
        if(instance == null)
            instance = new MainController(mainActivity);
        return instance;
    }

    public MainController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void onCreate() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.balldontlie.io/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        NbaRestApi nbaRestApi = retrofit.create(NbaRestApi.class);

        Call<RestTeamsResponse> call = nbaRestApi.getListTeams();

        call.enqueue(new Callback<RestTeamsResponse>() {
            @Override
            public void onResponse(Call<RestTeamsResponse> call, Response<RestTeamsResponse> response) {
                RestTeamsResponse restTeamsResponse = response.body();
                List<Teams> teamsList = restTeamsResponse.getData();
                mainActivity.showList(teamsList);
            }
            @Override
            public void onFailure(Call<RestTeamsResponse> call, Throwable t) {
                Log.d("Error", "API ERROR");
            }
        });
    }
}




