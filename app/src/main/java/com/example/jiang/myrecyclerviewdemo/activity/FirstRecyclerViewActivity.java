package com.example.jiang.myrecyclerviewdemo.activity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jiang.myrecyclerviewdemo.R;
import com.example.jiang.myrecyclerviewdemo.adapter.FirstRecAdapter;
import com.example.jiang.myrecyclerviewdemo.face.OnItemClickListener;
import com.example.jiang.myrecyclerviewdemo.itemdirect.ItemDirection;
import com.example.jiang.myrecyclerviewdemo.utils.SnackBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class FirstRecyclerViewActivity extends BaseActivity {


    @Bind(R.id.first_recycle)
    RecyclerView mRecycleView;

    @Override
    protected void initViewWithEvents() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView.LayoutManager mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecycleView.setLayoutManager(mManager);
        mRecycleView.addItemDecoration(new ItemDirection());
        mRecycleView.setItemAnimator(new DefaultItemAnimator());
        List<String> mValues = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            mValues.add("第" + i + "条数据");
        }
        FirstRecAdapter mAdapter = new FirstRecAdapter(this, mValues);
        mAdapter.setmOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(View v, int position) {
                SnackBarUtils.showShortSnackBar(v, "你点击了" + position + "位置的值");
            }
        });
        mRecycleView.setAdapter(mAdapter);

    }

    @Override
    public boolean isNeedSystemBarTint() {
        return true;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_first_recycler_view;
    }

    @Override
    public int getColorID() {
        return getResources().getColor(R.color.colorAccent);
    }
}
