package com.example.nba;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.nba.model.RestTeamsResponse;
import com.example.nba.model.Teams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        //On crée un objet Gson
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //On crée un objet retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.balldontlie.io/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //On crée notre interface PokemonRestApi
        NbaRestApi nbaRestApi  = retrofit.create(NbaRestApi.class);

        //On récupére un objet call.
        Call<RestTeamsResponse> call = nbaRestApi.getListTeams();

        call.enqueue(new Callback<RestTeamsResponse>() {
            @Override
            public void onResponse(Call<RestTeamsResponse> call, Response<RestTeamsResponse> response) {
                RestTeamsResponse restTeamsResponse = response.body();
                List<Teams> teamsList = restTeamsResponse.getData();
                showList(teamsList);
            }

            @Override
            public void onFailure(Call<RestTeamsResponse> call, Throwable t) {
                Log.d("Erreur", "API ERROR");
            }
        });
    }

    public void showList(List<Teams> list) {
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MyAdapter(list);
        recyclerView.setAdapter(mAdapter);

    }
}
