package com.example.jiang.myrecyclerviewdemo.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jiang.myrecyclerviewdemo.R;
import com.example.jiang.myrecyclerviewdemo.adapter.GridViewWithHeaderAdapter;
import com.example.jiang.myrecyclerviewdemo.face.OnItemClickListener;
import com.example.jiang.myrecyclerviewdemo.utils.SnackBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class GridViewWithHeaderActivity extends BaseActivity {


    @Bind(R.id.four_recycle)
    RecyclerView mRecyclerView;
    private GridViewWithHeaderAdapter mAdapter;
    private GridLayoutManager mManager;

    @Override
    protected void initViewWithEvents() {
        initRecyclerView();

    }

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);

        mManager = new GridLayoutManager(this, 3);

        mManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
            @Override
            public int getSpanSize(int position) {
                return (3 - position % 3);
            }
        });


        mRecyclerView.setLayoutManager(mManager);

        List<String> mDatas = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            mDatas.add(i + "");

        }


        mAdapter = new GridViewWithHeaderAdapter(this, mDatas);
        mAdapter.setmCallBack(new OnItemClickListener() {
            @Override
            public void OnItemClick(View v, int position) {

                SnackBarUtils.showShortSnackBar(v, "你点击了" + position);
            }
        });

        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean isNeedSystemBarTint() {
        return true;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_grid_view_with_header;
    }

    @Override
    public int getColorID() {
        return R.color.colorPrimary;
    }
}
