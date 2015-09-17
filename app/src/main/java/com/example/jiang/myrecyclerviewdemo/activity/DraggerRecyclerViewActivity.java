package com.example.jiang.myrecyclerviewdemo.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.jiang.myrecyclerviewdemo.R;
import com.example.jiang.myrecyclerviewdemo.adapter.RecyclerListAdapter;
import com.example.jiang.myrecyclerviewdemo.helper.OnStartDragListener;
import com.example.jiang.myrecyclerviewdemo.helper.SimpleItemTouchHelperCallback;

import butterknife.Bind;

public class DraggerRecyclerViewActivity extends BaseActivity implements OnStartDragListener {


    @Bind(R.id.dragger_recyclerview_recycle)
    RecyclerView recyclerView;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void initViewWithEvents() {

        initRecyclerView();

    }

    private void initRecyclerView() {
        RecyclerListAdapter adapter = new RecyclerListAdapter(this, this);


        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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
        return R.layout.activity_dragger_recycler_view;
    }

    @Override
    public int getColorID() {
        return 0;
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {

    }
}
