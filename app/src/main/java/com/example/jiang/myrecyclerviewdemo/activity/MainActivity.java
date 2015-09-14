package com.example.jiang.myrecyclerviewdemo.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.jiang.myrecyclerviewdemo.R;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button mFirst;

    @Override
    protected void initViewWithEvents() {
        mFirst = (Button) findViewById(R.id.first_re);
        mFirst.setOnClickListener(this);
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


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.first_re:
                startAc();
                break;
        }
    }

    private void startAc() {
        Intent intent = new Intent(this, FirstRecyclerViewActivity.class);
        startActivity(intent);
    }
}
