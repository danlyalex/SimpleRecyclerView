package com.example.jiang.myrecyclerviewdemo.itemdirect;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by jiang on 15/9/14.
 */
public class ItemDirection extends RecyclerView.ItemDecoration {
    public ItemDirection() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#FF4081"));

    }

    Paint paint = null;

    @Override
    public void onDraw(Canvas c, RecyclerView parent) {
        super.onDraw(c, parent);
        drawHo(c, parent); //为每一个item绘制下划线

    }

    private void drawHo(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        final int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            final View v = parent.getChildAt(i);
            c.drawLine(left, v.getBottom(), right, v.getBottom(), paint); //绘制下划线
        }


    }


}
