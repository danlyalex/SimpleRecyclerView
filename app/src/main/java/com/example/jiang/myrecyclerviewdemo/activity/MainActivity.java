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

    @Bind(R.id.third_re)
    Button mThird;

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

    @OnClick(R.id.third_re)
    void startThirdActicity() {
        startAc(StaggeredGridLayoutActivity.class);
    }


    @OnClick(R.id.four_re)
    void starFourActicity() {
        startAc(GridViewWithHeaderActivity.class);
    }

    @OnClick(R.id.five_re)
    void startFiveActivity() {
        startAc(GridViewWithMultyStateActivity.class);
    }


    @OnClick(R.id.six_re)
    void startSixActivity() {

        startAc(RefreshLoadMoreActivity.class);
    }

    @OnClick(R.id.seven_re)
    void startSevenActivity() {
        startAc(LoadMoreRecyclerView2Activity.class);
    }

    @OnClick(R.id.eight_re)
    void starteightActivity() {
        startAc(DraggerRecyclerViewActivity.class);
    }

    @OnClick(R.id.night_re)
    void startnightActivity() {
        startAc(DraggerGridViewActivity.class);
    }

    private void startAc(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }


}
