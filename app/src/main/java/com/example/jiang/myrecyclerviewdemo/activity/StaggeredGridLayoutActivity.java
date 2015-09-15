package com.example.jiang.myrecyclerviewdemo.activity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.jiang.myrecyclerviewdemo.R;
import com.example.jiang.myrecyclerviewdemo.adapter.StaggeredGridAdapter;
import com.example.jiang.myrecyclerviewdemo.model.StaggerModel;

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

        List<StaggerModel> mTitle = new ArrayList<>();
        for (int i = 0; i < 40; i++) {

            String img;
            if (i % 2 == 0) {
                img = "https://github.com/square/picasso/raw/master/website/static/sample.png";
            } else {
                img = "http://q.infoqstatic.com/qconbeijing2015/img/20150122/logo2x.png";
            }
            StaggerModel model = new StaggerModel(i + "", img);


            mTitle.add(model);
        }

        List<Integer> mInteger = new ArrayList<>();
        for (int j = 0; j < 40; j++) {
            mInteger.add((int) (Math.random() * 100));
        }


        mAdapter = new StaggeredGridAdapter(this, mTitle, mInteger);

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
        return R.color.colorPrimary;
    }
}
