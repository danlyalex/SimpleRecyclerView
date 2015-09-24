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
 * Created by jiang on 15/9/15.
 */
public class GridViewWithHeaderAdapter extends BaseAdapter<String, GridViewWithHeaderViewHolder> {

    private OnItemClickListener mCallBack;

    public GridViewWithHeaderAdapter(Context mContext, List<String> mDatas) {
        super(mDatas, mContext);
    }

    public OnItemClickListener getmCallBack() {
        return mCallBack;
    }

    public void setmCallBack(OnItemClickListener mCallBack) {
        this.mCallBack = mCallBack;
    }

    @Override

    public GridViewWithHeaderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GridViewWithHeaderViewHolder holder = new GridViewWithHeaderViewHolder(LayoutInflater.from(mContext).inflate(R.layout.gridviewwithheader_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final GridViewWithHeaderViewHolder holder, final int position) {
        holder.mTitle.setText(mDatas.get(position));
        if (mCallBack != null) {
            holder.mTitle.setClickable(true);
            holder.mTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCallBack.OnItemClick(holder.mTitle, position);
                }
            });
        }


    }


}

class GridViewWithHeaderViewHolder extends BaseViewHolder {

    TextView mTitle;

    public GridViewWithHeaderViewHolder(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.gridviewwhthheader_item_tv);
    }
}
