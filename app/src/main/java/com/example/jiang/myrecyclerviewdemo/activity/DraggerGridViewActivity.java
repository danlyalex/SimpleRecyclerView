package com.example.jiang.myrecyclerviewdemo.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.jiang.myrecyclerviewdemo.R;
import com.example.jiang.myrecyclerviewdemo.adapter.RecyclerListAdapter;
import com.example.jiang.myrecyclerviewdemo.helper.OnStartDragListener;
import com.example.jiang.myrecyclerviewdemo.helper.SimpleItemTouchHelperCallback;

import butterknife.Bind;

public class DraggerGridViewActivity extends BaseActivity implements OnStartDragListener {


    @Bind(R.id.dragger_gridview_recycle)
    RecyclerView recyclerView;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void initViewWithEvents() {
        final RecyclerListAdapter adapter = new RecyclerListAdapter(this, this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        final int spanCount = getResources().getInteger(R.integer.grid_columns);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, spanCount);
        recyclerView.setLayoutManager(layoutManager);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public boolean isNeedSystemBarTint() {
        return true;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_dragger_grid_view;
    }

    @Override
    public int getColorID() {
        return 0;
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {

    }
}
