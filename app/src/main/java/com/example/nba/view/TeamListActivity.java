package com.example.nba.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nba.controller.TeamController;
import com.example.nba.MyAdapterTeams;
import com.example.nba.R;
import com.example.nba.model.Teams;

import java.util.List;


public class TeamListActivity extends BaseListActivity {

    private TeamController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        controller = new TeamController(this);
        controller.onCreate();
    }

    public void showList(List<Teams> list){
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MyAdapterTeams(list);
        recyclerView.setAdapter(mAdapter);
    }
}
