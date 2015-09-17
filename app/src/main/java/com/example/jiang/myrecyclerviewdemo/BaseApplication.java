package com.example.jiang.myrecyclerviewdemo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by jiang on 15/9/16.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
