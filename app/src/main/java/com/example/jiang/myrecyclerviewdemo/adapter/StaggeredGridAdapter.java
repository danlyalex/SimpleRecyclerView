package com.example.jiang.myrecyclerviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jiang.myrecyclerviewdemo.R;
import com.example.jiang.myrecyclerviewdemo.model.StaggerModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jiang on 15/9/15.
 */
public class StaggeredGridAdapter extends BaseAdapter<StaggerModel, StaggeredGridViewHolder> {

    public StaggeredGridAdapter(List<StaggerModel> mDatas, Context mContext) {
        super(mDatas, mContext);
    }

    public StaggeredGridAdapter() {
    }

    @Override
    public StaggeredGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        StaggeredGridViewHolder holder = new StaggeredGridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.staggeredgrid_item, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(StaggeredGridViewHolder holder, int position) {
        Picasso.with(mContext).load(mDatas.get(position).getImgUrl()).into(holder.mImg);


    }
}

class StaggeredGridViewHolder extends BaseViewHolder {

    ImageView mImg;

    public StaggeredGridViewHolder(View itemView) {
        super(itemView);
        mImg = (ImageView) itemView.findViewById(R.id.StaggeredGrid_item_iv);
    }
}
