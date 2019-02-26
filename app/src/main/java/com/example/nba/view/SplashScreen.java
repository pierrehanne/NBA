package com.example.nba.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nba.R;

public class SplashScreen extends AppCompatActivity {

    private static int timer = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent start = new Intent(SplashScreen.this, MenuActivity.class);
                startActivity(start);
                finish();
            }
        },timer);
    }
}
