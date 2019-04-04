package com.example.mvpdemo.view.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.mvpdemo.R;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = initLayout();
        setContentView(layoutId);
        initView();
        inidData();
    }

    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void inidData();
}
