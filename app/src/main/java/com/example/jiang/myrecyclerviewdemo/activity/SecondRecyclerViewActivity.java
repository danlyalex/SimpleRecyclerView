package com.example.jiang.myrecyclerviewdemo.activity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jiang.myrecyclerviewdemo.R;
import com.example.jiang.myrecyclerviewdemo.adapter.SecondRecyclerAdapter;
import com.example.jiang.myrecyclerviewdemo.utils.SnackBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class SecondRecyclerViewActivity extends BaseActivity {


    @Bind(R.id.second_recycle)
    RecyclerView mRecycleView;

    @Override
    protected void initViewWithEvents() {
        RecyclerView.LayoutManager mManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecycleView.setLayoutManager(mManager);
        mRecycleView.setItemAnimator(new DefaultItemAnimator());
        List<String> mValues = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            mValues.add(i+"");
        }
        SecondRecyclerAdapter mAdapter = new SecondRecyclerAdapter(this, mValues);
        mAdapter.setmOnItemClickListener(new SecondRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                SnackBarUtils.showShortSnackBar(v, "你点击了" + position + "位置的值");
            }
        });
        mRecycleView.setAdapter(mAdapter);

    }

    @Override
    public boolean isNeedSystemBarTint() {
        return false;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_second_recycler_view;
    }

    @Override
    public int getColorID() {
        return 0;
    }
}
