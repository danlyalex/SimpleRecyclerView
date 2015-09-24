package com.example.jiang.myrecyclerviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jiang.myrecyclerviewdemo.R;
import com.example.jiang.myrecyclerviewdemo.face.OnItemClickListener;

import java.util.List;

/**
 * Created by jiang on 15/9/16.
 */
public class RefreshAdapter extends BaseAdapter<String, RefreshViewHolder> {

    public RefreshAdapter(List<String> mDatas, Context mContext) {
        super(mDatas, mContext);
    }

    public RefreshAdapter() {
    }

    private OnItemClickListener mOnItemClickListener;

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    @Override
    public RefreshViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RefreshViewHolder holder = new RefreshViewHolder(LayoutInflater.from(mContext).inflate(R.layout.first_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final RefreshViewHolder holder, int position) {

        if (position == mDatas.size() - 1) {
            holder.mTitle.setText("正在加载更多");
            return;
        }

        holder.mTitle.setText(mDatas.get(position));
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getAdapterPosition();
                    mOnItemClickListener.OnItemClick(holder.itemView, pos);
                }
            });
        }

    }


}

class RefreshViewHolder extends BaseViewHolder{

    TextView mTitle;

    public RefreshViewHolder(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.first_item_tv);
    }
}