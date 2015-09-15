package com.example.jiang.myrecyclerviewdemo.activity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.jiang.myrecyclerviewdemo.R;
import com.example.jiang.myrecyclerviewdemo.adapter.StaggeredGridAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class StaggeredGridLayoutActivity extends BaseActivity {


    @Bind(R.id.third_recycle)
    RecyclerView mRecyclerView;
    private StaggeredGridAdapter mAdapter;
    private StaggeredGridLayoutManager mManager;

    @Override
    protected void initViewWithEvents() {
        initRecyclerView();

    }

    private void initRecyclerView() {
        mManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mManager);

        List<String> mTitle = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            mTitle.add("第" + i + "个图片");
        }


        mAdapter = new StaggeredGridAdapter(this, mTitle);

        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean isNeedSystemBarTint() {
        return true;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_staggered_grid_layout;
    }

    @Override
    public int getColorID() {
        return 0;
    }
}
