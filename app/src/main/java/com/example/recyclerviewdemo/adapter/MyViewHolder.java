package com.example.recyclerviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.recyclerviewdemo.R;

/**
 * Created by Administrator
 * Date: 2016/1/28.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView tv;
    public MyViewHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.id_num);
    }
}
