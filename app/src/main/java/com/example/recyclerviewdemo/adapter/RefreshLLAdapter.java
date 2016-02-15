package com.example.recyclerviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator
 * Date: 2016/2/15.
 */
public class RefreshLLAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Integer> list;
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public RefreshLLAdapter() {
        list = new ArrayList<Integer>();
    }

    public List<Integer> getList() {
        return list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == TYPE_ITEM) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_text, null);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return new ItemViewHoler(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof  ItemViewHoler) {
            ((ItemViewHoler) viewHolder).textView.setText(String.valueOf(list.get(i)));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class FooterViewHoler extends RecyclerView.ViewHolder {

        public FooterViewHoler(View itemView) {
            super(itemView);
        }
    }

    class ItemViewHoler extends RecyclerView.ViewHolder {
        TextView textView;
        public ItemViewHoler(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
