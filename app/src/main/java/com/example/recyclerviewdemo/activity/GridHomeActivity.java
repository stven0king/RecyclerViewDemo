package com.example.recyclerviewdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclerviewdemo.adapter.GLDividerItemDecoration;
import com.example.recyclerviewdemo.adapter.HomeAdapter;
import com.example.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator
 * Date: 2016/1/29.
 */
public class GridHomeActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private HomeAdapter homeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        homeAdapter = new HomeAdapter(this,mDatas);
        mRecyclerView.setAdapter(homeAdapter);
        mRecyclerView.addItemDecoration(new GLDividerItemDecoration(this));
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i <= 'z'; i++) {
            mDatas.add("" + (char)i);
        }
    }
}
