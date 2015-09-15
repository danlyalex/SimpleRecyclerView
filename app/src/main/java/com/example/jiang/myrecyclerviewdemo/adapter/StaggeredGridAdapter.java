package com.example.jiang.myrecyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiang.myrecyclerviewdemo.R;

import java.util.List;

/**
 * Created by jiang on 15/9/15.
 */
public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridViewHolder> {

    private List<String> mDatas;
    private Context mContext;


    public StaggeredGridAdapter(Context mContext, List<String> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public StaggeredGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        StaggeredGridViewHolder holder = new StaggeredGridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.staggeredgrid_item, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(StaggeredGridViewHolder holder, int position) {
        holder.mTitle.setText(mDatas.get(position));

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}

class StaggeredGridViewHolder extends RecyclerView.ViewHolder {

    ImageView mImg;
    TextView mTitle;

    public StaggeredGridViewHolder(View itemView) {
        super(itemView);
        mImg = (ImageView) itemView.findViewById(R.id.StaggeredGrid_item_iv);
        mTitle = (TextView) itemView.findViewById(R.id.StaggeredGrid_item_tv);
    }
}
