package com.example.jiang.myrecyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridViewHolder> {

    private List<StaggerModel> mDatas;
    private List<Integer> mInteger;
    private Context mContext;


    public StaggeredGridAdapter(Context mContext, List<StaggerModel> mDatas, List<Integer> mInteger) {
        this.mContext = mContext;
        this.mInteger = mInteger;
        this.mDatas = mDatas;
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

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}

class StaggeredGridViewHolder extends RecyclerView.ViewHolder {

    ImageView mImg;

    public StaggeredGridViewHolder(View itemView) {
        super(itemView);
        mImg = (ImageView) itemView.findViewById(R.id.StaggeredGrid_item_iv);
    }
}
