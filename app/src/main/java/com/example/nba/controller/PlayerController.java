package com.example.nba.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.nba.NbaRestApi;
import com.example.nba.model.Players;
import com.example.nba.model.RestPlayersReponse;
import com.example.nba.view.PlayerListActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;


public class PlayerController {

    private static final String PREFS = "PREFS";
    private static final String PREFS_KEY = "PREFS_KEY";
    private static final String PREFS_STRING = "PREFS_STRING";

    private SharedPreferences sharedPreferences;

    private final PlayerListActivity playerActivity;
    private static PlayerController instance = null;

    public static PlayerController getInstance(PlayerListActivity playerActivity) {
        if (instance == null)
            instance = new PlayerController(playerActivity);
        return instance;
    }

    public PlayerController(PlayerListActivity playerActivity) {
        this.playerActivity = playerActivity;
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

        Call<RestPlayersReponse> call = nbaRestApi.getListPlayers();

        sharedPreferences = playerActivity.getBaseContext().getSharedPreferences(PREFS, MODE_PRIVATE);
        String result = sharedPreferences.getString(PREFS_STRING, "");

        if (result.isEmpty()) {
            call.enqueue(new Callback<RestPlayersReponse>() {
                @Override
                public void onResponse(Call<RestPlayersReponse> call, Response<RestPlayersReponse> response) {
                    RestPlayersReponse restPlayersResponse = response.body();
                    List<Players> playersList = restPlayersResponse.getData();

                    Gson gson = new Gson();
                    String jsonListPlayers = gson.toJson(playersList);

                    playerActivity.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);

                    sharedPreferences
                            .edit()
                            .putInt(PREFS_KEY, 1)
                            .putString(PREFS_STRING, jsonListPlayers)
                            .apply();

                    String result = sharedPreferences.getString(PREFS_STRING, "");

                    playerActivity.showList(playersList);
                }

                @Override
                public void onFailure(Call<RestPlayersReponse> call, Throwable t) {
                    Log.d("Error", "API ERROR");
                }
            });
        } else {
            Type listType = new TypeToken<List<Players>>(){}.getType();
            Gson gsonTest = new Gson();
            List<Players> list = gsonTest.fromJson(result, listType);
            playerActivity.showList(list);
        }
    }
}
