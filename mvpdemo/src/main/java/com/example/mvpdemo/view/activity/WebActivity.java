package com.example.mvpdemo.view.activity;

import android.webkit.WebView;

import com.example.mvpdemo.R;

/**
 * 作者：陈飞
 * 时间：2019/09/12 14:07
 */
public class WebActivity extends BaseActivity {

    private WebView webView;

    @Override
    protected int initLayout() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {
        webView = findViewById(R.id.web_view);
    }

    @Override
    protected void inidData() {
        String url = getIntent().getStringExtra("url");
        webView.loadUrl(url);
    }

    @Override
    protected void destory() {

    }
}
