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
public class GridViewWithMultyStateAdapter extends BaseAdapter<String, GridViewWithMultyStateViewHolder> {

    private static final int ITEM_VIEW_TYPE_HEADER = 0;
    private static final int ITEM_VIEW_TYPE_ITEM = 1;

    public OnItemClickListener getmListener() {
        return mListener;
    }

    public void setmListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    private OnItemClickListener mListener;

    public GridViewWithMultyStateAdapter(List<String> mDatas, Context mContext) {
        super(mDatas, mContext);
    }

    public GridViewWithMultyStateAdapter() {
    }

    @Override
    public GridViewWithMultyStateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_VIEW_TYPE_HEADER) {
            return new GridViewWithMultyStateViewHolder(LayoutInflater.from(mContext).inflate(R.layout.gridviewmultystate_header, parent, false), false);
        } else {
            return new GridViewWithMultyStateViewHolder(LayoutInflater.from(mContext).inflate(R.layout.gridviewmultystate_item, parent, false), true);
        }

    }

    @Override
    public void onBindViewHolder(GridViewWithMultyStateViewHolder holder, final int position) {
        if (isHeader(position)) {
            return;
        }
        holder.mImg.setText(mDatas.get(position - 1));
        if (mListener != null) {
            holder.mImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.OnItemClick(view, position);
                }
            });
        }
    }


    @Override
    public int getItemViewType(int position) {
        return isHeader(position) ? ITEM_VIEW_TYPE_HEADER : ITEM_VIEW_TYPE_ITEM;
    }

    public boolean isHeader(int position) {
        return position == 0 ? true : false;
    }


}

class GridViewWithMultyStateViewHolder extends BaseViewHolder {

    TextView mImg;

    public GridViewWithMultyStateViewHolder(View itemView, boolean needFind) {
        super(itemView);
        if (needFind) {
            mImg = (TextView) itemView.findViewById(R.id.gridviewwhthmultystate_item_tv);
        }
    }
}


