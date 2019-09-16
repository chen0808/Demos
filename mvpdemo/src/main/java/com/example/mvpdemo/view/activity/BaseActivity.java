package com.example.mvpdemo.view.activity;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = initLayout();
        setContentView(layoutId);
        ButterKnife.bind(this);
        initView();
        inidData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destory();
    }

    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void inidData();

    protected abstract void destory();
}
