package com.example.jiang.myrecyclerviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jiang.myrecyclerviewdemo.R;

import java.util.List;

/**
 * Created by jiang on 15/9/24.
 */
public class SwipeRecyclerViewAdapter extends BaseAdapter<String, SwipeViewHolder> {

    public SwipeRecyclerViewAdapter(List<String> mDatas, Context mContext) {
        super(mDatas, mContext);
    }

    @Override
    public SwipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.swipe_recyclerview_item, parent, false);

        return new SwipeViewHolder(v);
    }


    @Override
    public void onBindViewHolder(SwipeViewHolder holder, int position) {

        holder.mTitle.setText(mDatas.get(position));


    }


}

class SwipeViewHolder extends BaseViewHolder {

    TextView mTitle;

    public SwipeViewHolder(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.swipe_textview);
    }
}
