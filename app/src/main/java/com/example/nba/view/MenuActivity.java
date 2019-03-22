package com.example.nba.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.nba.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void teams (View view) {
        startActivity(new Intent(this, TeamListActivity.class));
    }

    public void logo (View view) {
        startActivity(new Intent(this, NbaLogoActivity.class));
    }

    public void video (View view) {
        startActivity(new Intent(this, NbaYoutubeActivity.class));
    }

}
