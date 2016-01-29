package com.example.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.recyclerviewdemo.R;

import java.util.List;

/**
 * Created by Administrator
 * Date: 2016/1/28.
 */
public class HomeAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context mContext;
    private List<String> mData;
    public HomeAdapter(Context mContext,List<String> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_main, viewGroup, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.tv.setPadding(30, 30, 30, 30);
        myViewHolder.tv.setText(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
