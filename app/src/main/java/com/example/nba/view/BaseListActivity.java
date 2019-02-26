package com.example.nba.view;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

abstract class BaseListActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    public RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager layoutManager;
}
