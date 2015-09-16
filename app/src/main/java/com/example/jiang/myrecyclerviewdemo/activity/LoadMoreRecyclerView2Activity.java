package com.example.jiang.myrecyclerviewdemo.activity;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jiang.myrecyclerviewdemo.R;
import com.example.jiang.myrecyclerviewdemo.adapter.FirstRecAdapter;
import com.example.jiang.myrecyclerviewdemo.face.OnButtomListener;
import com.example.jiang.myrecyclerviewdemo.face.OnItemClickListener;
import com.example.jiang.myrecyclerviewdemo.utils.SnackBarUtils;
import com.example.jiang.myrecyclerviewdemo.widget.LoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class LoadMoreRecyclerView2Activity extends BaseActivity {


    List<String> mValues = new ArrayList<>();
    private int count = 0;
    @Bind(R.id.seven_recycle)
    LoadMoreRecyclerView mRecycleView;
    private FirstRecAdapter mAdapter;


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

        mRecycleView.setOnButtomListener(new OnButtomListener() {
            @Override
            public void onButtom() {
                SnackBarUtils.showShortSnackBar(mRecycleView, "已经到底部，开始加载更多");
                doLoadMore();
            }
        });

    }

    void doLoadMore() {

        mRecycleView.setLoadmore_state(LoadMoreRecyclerView.STATE_START_LOADMORE);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                fillData2List();
                mRecycleView.setLoadmore_state(LoadMoreRecyclerView.STATE_FINISH_LOADMORE);
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
        return R.layout.activity_load_more_recycler_view2;
    }

    @Override
    public int getColorID() {
        return 0;
    }
}
