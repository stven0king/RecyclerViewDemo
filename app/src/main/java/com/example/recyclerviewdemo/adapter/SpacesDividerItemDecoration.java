package com.example.recyclerviewdemo.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator
 * Date: 2016/1/29.
 */
public class SpacesDividerItemDecoration extends RecyclerView.ItemDecoration {

    private Context mContext;
    private int space;

    public SpacesDividerItemDecoration(Context mContext, int space) {
        this.mContext = mContext;
        this.space = space;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent) {
        super.onDraw(c, parent);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left=space;
        outRect.right=space;
        outRect.bottom=space;
        if(parent.getChildPosition(view) >= 3){
            outRect.top=space;
        }
    }
}
