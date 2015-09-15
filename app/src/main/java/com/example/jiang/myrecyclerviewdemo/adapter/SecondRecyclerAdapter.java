package com.example.jiang.myrecyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jiang.myrecyclerviewdemo.R;
import com.example.jiang.myrecyclerviewdemo.face.OnItemClickListener;

import java.util.List;

/**
 * Created by jiang on 15/9/14.
 */
public class SecondRecyclerAdapter extends RecyclerView.Adapter<ViewHolder2> {

    private Context mContext;

    private List<String> mValues;

    private OnItemClickListener mOnItemClickListener;


    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public SecondRecyclerAdapter(Context mContext, List<String> mValues) {
        this.mContext = mContext;
        this.mValues = mValues;
    }

    @Override
    public ViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder2 holder = new ViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.second_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder2 holder, int position) {
        holder.mTitle.setText(mValues.get(position));
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

    @Override
    public int getItemCount() {
        return mValues.size();
    }

}

class ViewHolder2 extends RecyclerView.ViewHolder {

    TextView mTitle;

    public ViewHolder2(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.second_item_tv);
    }
}


