package com.example.nba.controller;

import com.example.nba.NbaRestApi;
import com.example.nba.model.RestTeamsResponse;
import com.example.nba.model.Teams;
import com.example.nba.view.TeamListActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;


public class TeamController {

    private static final String PREFS = "PREFS";
    private static final String PREFS_KEY = "PREFS_KEY";
    private static final String PREFS_STRING = "PREFS_STRING";

    private SharedPreferences sharedPreferences;


    private final TeamListActivity teamActivity;
    private static TeamController instance = null;


    public static TeamController getInstance(TeamListActivity teamActivity){
        if(instance == null)
            instance = new TeamController(teamActivity);
        return instance;
    }

    public TeamController(TeamListActivity teamActivity) {
        this.teamActivity = teamActivity;
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

        sharedPreferences = teamActivity.getBaseContext().getSharedPreferences(PREFS, MODE_PRIVATE);
        String result = sharedPreferences.getString(PREFS_STRING, "");

        if (result.isEmpty()) {
            call.enqueue(new Callback<RestTeamsResponse>() {
                @Override
                public void onResponse(Call<RestTeamsResponse> call, Response<RestTeamsResponse> response) {
                    RestTeamsResponse restTeamsResponse = response.body();
                    List<Teams> teamsList = restTeamsResponse.getData();

                    Gson gson = new Gson();
                    String jsonListTeams = gson.toJson(teamsList);

                    teamActivity.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);

                    sharedPreferences
                            .edit()
                            .putInt(PREFS_KEY, 1)
                            .putString(PREFS_STRING, jsonListTeams)
                            .apply();

                    String result = sharedPreferences.getString(PREFS_STRING, "");

                    teamActivity.showList(teamsList);
                }

                @Override
                public void onFailure(Call<RestTeamsResponse> call, Throwable t) {
                    Log.d("Error", "API ERROR");
                }
            });
        } else {
            Type listType = new TypeToken<List<Teams>>(){}.getType();
            Gson gsonTest = new Gson();
            List<Teams> list = gsonTest.fromJson(result, listType);
            teamActivity.showList(list);
        }
    }
}




