package com.example.mvpdemo;

import android.app.Application;

import com.example.mvpdemo.utils.LoadingUtils;

/**
 * 作者：陈飞
 * 时间：2019/08/27 14:11
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化loading
        LoadingUtils.init(this);
    }
}
