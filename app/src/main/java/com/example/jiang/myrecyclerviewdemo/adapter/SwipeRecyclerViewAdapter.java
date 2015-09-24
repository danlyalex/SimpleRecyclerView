package com.example.jiang.myrecyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jiang.myrecyclerviewdemo.R;

import java.util.List;

/**
 * Created by jiang on 15/9/24.
 */
public class SwipeRecyclerViewAdapter extends RecyclerView.Adapter<SwipeViewHolder> {

    public SwipeRecyclerViewAdapter(List<String> mDatas, Context mContext) {
        this.mDatas = mDatas;
        this.mContext = mContext;
    }

    private List<String> mDatas;
    private Context mContext;

    @Override
    public SwipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.swipe_recyclerview_item, parent, false);

        return new SwipeViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(SwipeViewHolder holder, int position) {

        holder.mTitle.setText(mDatas.get(position));


    }


}

class SwipeViewHolder extends RecyclerView.ViewHolder {

    TextView mTitle;

    public SwipeViewHolder(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.swipe_textview);
    }
}
