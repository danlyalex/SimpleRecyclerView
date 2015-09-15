package com.example.jiang.myrecyclerviewdemo.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jiang.myrecyclerviewdemo.R;
import com.example.jiang.myrecyclerviewdemo.adapter.GridViewWithMultyStateAdapter;
import com.example.jiang.myrecyclerviewdemo.face.OnItemClickListener;
import com.example.jiang.myrecyclerviewdemo.utils.SnackBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class GridViewWithMultyStateActivity extends BaseActivity {


    @Bind(R.id.five_recycle)
    RecyclerView mRecyclerView;
    private GridLayoutManager mManager;
    private GridViewWithMultyStateAdapter mAdapter;

    @Override
    protected void initViewWithEvents() {

        initRecyclerView();

    }

    private void initRecyclerView() {
        mManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mManager);
        List<String> mValues = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            mValues.add(i + "");
        }
        mAdapter = new GridViewWithMultyStateAdapter(this, mValues);

        mRecyclerView.setAdapter(mAdapter);
        mManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mAdapter.isHeader(position) ? mManager.getSpanCount() : 3 - (position - 1) % 3;
            }
        });

        mAdapter.setmListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(View v, int position) {
                if (position == 0) {
                    SnackBarUtils.showShortSnackBar(v, "你点击了Header");
                } else {
                    SnackBarUtils.showShortSnackBar(v, "你点击了" + (position - 1));
                }
            }
        });

    }

    @Override
    public boolean isNeedSystemBarTint() {
        return true;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_grid_view_with_multy_state;
    }

    @Override
    public int getColorID() {
        return 0;
    }
}
