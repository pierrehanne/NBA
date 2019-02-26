package com.example.nba.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nba.MyAdapterPlayers;
import com.example.nba.R;
import com.example.nba.controller.PlayerController;
import com.example.nba.model.Players;

import java.util.List;

public class PlayerListActivity extends BaseListActivity {

    private PlayerController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        controller = new PlayerController(this);
        controller.onCreate();
    }

    public void showList(List<Players> list){
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapterPlayers(list);
        recyclerView.setAdapter(mAdapter);
    }
}

