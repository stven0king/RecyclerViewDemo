package com.example.recyclerviewdemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.adapter.SpacesDividerItemDecoration;
import com.example.recyclerviewdemo.adapter.StaggeredHomeAdapter;
import com.example.recyclerviewdemo.model.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator
 * Date: 2016/1/29.
 */
public class StaggeredHomeActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private StaggeredHomeAdapter homeAdapter;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_main);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        homeAdapter = new StaggeredHomeAdapter(this,mDatas);
        homeAdapter.setmOnItemClickListener(mOnItemClickListener);
        mRecyclerView.setAdapter(homeAdapter);
        mRecyclerView.addItemDecoration(new SpacesDividerItemDecoration(this, 12));
        // 设置item动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i <= 'z'; i++) {
            mDatas.add("" + (char)i);
        }
    }

    private OnItemClickListener mOnItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClickListener(View view, int postion) {
            Toast.makeText(mContext, "onItemClickListener " + mDatas.get(postion), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onItemLongClickListener(View view, int postion) {
            Toast.makeText(mContext, "onItemLongClickListener " + mDatas.get(postion), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.staggered_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_add:
                homeAdapter.addData(new Random().nextInt(5));
                break;
            case R.id.id_delete:
                homeAdapter.removeData(new Random().nextInt(5));
                break;
        }
        return true;
    }
}
