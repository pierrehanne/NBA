package com.example.nba.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.example.nba.MyAdapterImage;
import com.example.nba.R;

public class NbaLogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nba_logo);
        GridView gv = (GridView) findViewById(R.id.gridview);
        gv.setAdapter((ListAdapter) new MyAdapterImage(this));
    }
}
