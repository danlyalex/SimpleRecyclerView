package com.example.jiang.myrecyclerviewdemo.activity;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.example.jiang.myrecyclerviewdemo.R;
import com.example.jiang.myrecyclerviewdemo.adapter.FirstRecAdapter;
import com.example.jiang.myrecyclerviewdemo.face.OnItemClickListener;
import com.example.jiang.myrecyclerviewdemo.face.OnRecyclerViewScrollListener;
import com.example.jiang.myrecyclerviewdemo.utils.SnackBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class RefreshLoadMoreActivity extends BaseActivity {

    List<String> mValues = new ArrayList<>();
    private int count = 0;
    @Bind(R.id.six_recycle)
    RecyclerView mRecycleView;
    private FirstRecAdapter mAdapter;


    @Bind(R.id.six_refresh)
    MaterialRefreshLayout mRefreshLayout;


    private Handler mHandler = new Handler() {
    };

    @Override
    protected void initViewWithEvents() {

        initRecycclerView();

    }

    private void initRecycclerView() {
        RecyclerView.LayoutManager mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecycleView.setLayoutManager(mManager);

        fillData2List();
        mAdapter.setmOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(View v, int position) {
                SnackBarUtils.showShortSnackBar(v, "你点击了" + position + "位置的值");
            }
        });
        mRecycleView.setAdapter(mAdapter);
        mRecycleView.setOnScrollListener(new OnRecyclerViewScrollListener() {
            @Override
            public void onButtom() {
                super.onButtom();
                SnackBarUtils.showShortSnackBar(mRecycleView, "已经到底部，开始加载更多");
                doLoadMore();
            }
        });
        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {

                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        SnackBarUtils.showShortSnackBar(mRecycleView, "开始下拉刷新");
                        count = 0;
                        mValues.clear();
                        fillData2List();
                        materialRefreshLayout.finishRefresh();
                    }
                }, 3000);
            }
        });

    }

    void doLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                fillData2List();
            }
        }, 3000);
    }

    private void fillData2List() {


        for (int i = 0; i < 60; i++) {
            mValues.add("第" + count + "次，的第" + i + "条数据");
        }
        count++;
        if (mAdapter == null)
            mAdapter = new FirstRecAdapter(this, mValues);
        else
            mAdapter.notifyDataSetChanged();
        SnackBarUtils.showShortSnackBar(mRecycleView, "加载数据成功");
    }

    @Override
    public boolean isNeedSystemBarTint() {
        return true;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_refresh_load_more;
    }

    @Override
    public int getColorID() {
        return 0;
    }
}
