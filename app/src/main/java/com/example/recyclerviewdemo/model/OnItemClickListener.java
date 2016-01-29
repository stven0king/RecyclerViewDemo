package com.example.recyclerviewdemo.model;

import android.view.View;

/**
 * Created by Administrator
 * Date: 2016/1/29.
 */
public interface OnItemClickListener {
    void onItemClickListener(View view, int postion);
    void onItemLongClickListener(View view, int postion);
}
