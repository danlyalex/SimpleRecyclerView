package com.example.jiang.myrecyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by jiang on 15/9/24.
 */
public abstract class BaseAdapter<T, M extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<M> {

    protected List<T> mDatas;
    protected Context mContext;

    public BaseAdapter(List<T> mDatas, Context mContext) {
        this.mDatas = mDatas;
        this.mContext = mContext;
    }

    public BaseAdapter() {
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
