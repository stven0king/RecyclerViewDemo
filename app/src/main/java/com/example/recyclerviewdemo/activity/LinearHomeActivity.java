package com.example.recyclerviewdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclerviewdemo.adapter.HomeAdapter;
import com.example.recyclerviewdemo.adapter.LLDividerItemDecoration;
import com.example.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;

public class LinearHomeActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private HomeAdapter homeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        homeAdapter = new HomeAdapter(this,mDatas);
        mRecyclerView.setAdapter(homeAdapter);
        mRecyclerView.addItemDecoration(new LLDividerItemDecoration(this,LinearLayoutManager.VERTICAL));
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i <= 'z'; i++) {
            mDatas.add("" + (char)i);
        }
    }
}
