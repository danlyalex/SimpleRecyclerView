package com.example.jiang.myrecyclerviewdemo.activity;

import android.graphics.Canvas;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.jiang.myrecyclerviewdemo.R;
import com.example.jiang.myrecyclerviewdemo.adapter.SwipeRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;

public class SimpleSwipeRecyclerViewActivity extends BaseActivity {


    @Bind(R.id.simple_swipe_recycle)
    RecyclerView mView;
    private List<String> mDatas;
    private SwipeRecyclerViewAdapter mAdapter;

    @Override
    protected void initViewWithEvents() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mView.setLayoutManager(manager);
        mView.setHasFixedSize(true);
        mView.setItemAnimator(new DefaultItemAnimator());
        mDatas = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mDatas.add("这是" + i + "条");
        }


        setTouchHelper();


        mAdapter = new SwipeRecyclerViewAdapter(mDatas, this);
        mView.setAdapter(mAdapter);


    }

    private void setTouchHelper() {

        ItemTouchHelper.SimpleCallback mCallBack = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

                int fromPosition = viewHolder.getAdapterPosition();
                int toPosition = target.getAdapterPosition();
                //分别把中间所有的item的位置重新交换
                if (fromPosition < toPosition) {
                    for (int i = fromPosition; i < toPosition; i++) {
                        Collections.swap(mDatas, i, i++);
                    }
                } else {
                    for (int i = fromPosition; i > toPosition; i--) {
                        Collections.swap(mDatas, i, i - 1);
                    }
                }
                mAdapter.notifyItemMoved(fromPosition, toPosition);
                //返回true表示执行拖动
                return true;
            }


            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

                    final float alpha = 1 - Math.abs(dX) / (float) viewHolder.itemView.getWidth();
                    viewHolder.itemView.setAlpha(alpha);
                    viewHolder.itemView.setTranslationX(dX);
                }
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                int position = viewHolder.getAdapterPosition();
                mDatas.remove(position);
                mAdapter.notifyItemRemoved(position);
            }
        };

        ItemTouchHelper helper = new ItemTouchHelper(mCallBack);
        helper.attachToRecyclerView(mView);


    }

    @Override
    public boolean isNeedSystemBarTint() {
        return true;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_simple_swipe_recycler_view;
    }

    @Override
    public int getColorID() {
        return 0;
    }
}
