package com.example.jiang.myrecyclerviewdemo.activity;

import android.content.Intent;
import android.widget.Button;

import com.example.jiang.myrecyclerviewdemo.R;

import butterknife.Bind;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    @Bind(R.id.first_re)
    Button mFirst;


    @Bind(R.id.second_re)
    Button mSecond;

    @Override
    protected void initViewWithEvents() {

    }

    @Override
    public boolean isNeedSystemBarTint() {
        return true;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public int getColorID() {
        return 0;
    }


    @OnClick(R.id.first_re)
    void startFirstActicity() {
        startAc(FirstRecyclerViewActivity.class);
    }

    @OnClick(R.id.second_re)
    void startSecondActicity() {
        startAc(SecondRecyclerViewActivity.class);
    }

    private void startAc(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }


}
