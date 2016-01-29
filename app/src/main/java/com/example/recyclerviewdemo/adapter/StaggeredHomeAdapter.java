package com.example.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.model.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator
 * Date: 2016/1/29.
 */
public class StaggeredHomeAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<String> mDatas;
    private LayoutInflater mInflater;
    private Context mContext;
    private List<Integer> mHeights;
    private OnItemClickListener mOnItemClickListener;

    public OnItemClickListener getmOnItemClickListener() {
        return mOnItemClickListener;
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public StaggeredHomeAdapter(Context mContext, List<String> mDatas) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(this.mContext);
        mHeights = new ArrayList<Integer>();
        for (int i = 0; i < mDatas.size(); i++) {
            mHeights.add((int) (100 + Math.random() * 300));
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MyViewHolder holder = new MyViewHolder(mInflater.inflate(
                R.layout.item_main, viewGroup, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, int i) {
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)myViewHolder.tv.getLayoutParams();
        lp.height = mHeights.get(i);
        //if ((i + 1) % 3 != 0 && i < getItemCount() - 3) {
        //    lp.setMargins(0, 0, 10, 10);
        //} else {
        //    lp.setMargins(0, 0, 0, 10);
        //}
        myViewHolder.tv.setLayoutParams(lp);
        myViewHolder.tv.setText(mDatas.get(i));
        final int postion = i;
        if (mOnItemClickListener != null) {
            myViewHolder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClickListener(myViewHolder.tv, postion);
                }
            });
            myViewHolder.tv.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onItemLongClickListener(myViewHolder.tv, postion);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addData(int position) {
        mDatas.add(position, "Insert One");
        mHeights.add((int) (100 + Math.random() * 300));
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }
}
