package com.example.recyclerviewdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.widget.Toast;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.adapter.RefreshLLAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator
 * Date: 2016/2/14.
 */
public class RefreshLLActivity extends Activity{
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerView mRecyclerView;
    private RefreshLLAdapter adapter;
    private int lastVisibleItem;
    private int fristVisibleItem;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refresh_activity_main);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_widget);
        mRecyclerView = (RecyclerView) findViewById(android.R.id.list);
        adapter = new RefreshLLAdapter();
        mSwipeRefreshLayout.setColorSchemeResources(R.color.oldlace,
                R.color.gainsboro,
                R.color.aliceblue,
                R.color.darkblue);
        mSwipeRefreshLayout.setProgressViewOffset(false, 0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 240, getResources().getDisplayMetrics()));
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.d("tanzhenxing", "onScrollStateChanged");
                if (newState == RecyclerView.SCROLL_STATE_SETTLING
                        && lastVisibleItem + 1 == adapter.getItemCount()) {
                    mSwipeRefreshLayout.setRefreshing(true);
                    handler.sendEmptyMessageDelayed(1, 3000);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
                fristVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
            }
        });

        mRecyclerView.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(adapter);

        mSwipeRefreshLayout.post(new Runnable() {

            @SuppressWarnings("static-access")
            @Override
            public void run() {
                try {
                    handler.sendEmptyMessageDelayed(0, 3000);
                    Log.d("tanzhenxing","post");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //下拉执行刷新方法
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(0, 3000);
                Log.d("tanzhenxing","onRefresh");
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mSwipeRefreshLayout.setRefreshing(true);
    }

    private void addList() {
        List<Integer> list = getList();
        adapter.getList().addAll(list);
        adapter.notifyDataSetChanged();
    }

    private List<Integer> getList() {
        List<Integer> list = new ArrayList<Integer>();
        int size = adapter.getList().size();
        int lastPosition = size > 0 ? adapter.getList().get(size - 1) : 0;
        for (int i = 1; i < 20; i++) {
            list.add(lastPosition + i);
        }

        return list;
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Toast.makeText(RefreshLLActivity.this, "DOWN", Toast.LENGTH_SHORT).show();
                    mSwipeRefreshLayout.setRefreshing(false);

                    adapter.getList().clear();
                    addList();
                    break;
                case 1:
                    Toast.makeText(RefreshLLActivity.this, "UP", Toast.LENGTH_SHORT).show();
                    addList();
                    mSwipeRefreshLayout.setRefreshing(false);
                    break;
                default:
                    break;
            }
        }
    };
}
