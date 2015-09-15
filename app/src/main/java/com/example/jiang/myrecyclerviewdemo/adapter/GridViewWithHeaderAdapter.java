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
 * Created by jiang on 15/9/15.
 */
public class GridViewWithHeaderAdapter extends RecyclerView.Adapter<GridViewWithHeaderViewHolder> {

    private List<String> mDatas;
    private Context mContext;
    private ClickCallBack mCallBack;


    public GridViewWithHeaderAdapter(Context mContext, List<String> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    public ClickCallBack getmCallBack() {
        return mCallBack;
    }

    public void setmCallBack(ClickCallBack mCallBack) {
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
                    mCallBack.Click(holder.mTitle, position);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    public interface ClickCallBack {
        void Click(View v, int position);
    }

}

class GridViewWithHeaderViewHolder extends RecyclerView.ViewHolder {

    TextView mTitle;

    public GridViewWithHeaderViewHolder(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.gridviewwhthheader_item_tv);
    }
}
