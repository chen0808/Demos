package com.example.nanodemo;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MyWebService";
    private WebView web;
    private MyWebService myWebService;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.web);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);
        // 设置与Js交互的权限
        web.getSettings().setJavaScriptEnabled(true);
        // 设置允许JS弹窗
        web.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        //设置适应Html5 重点是这个设置
        web.getSettings().setDomStorageEnabled(true);
        web.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

        //设置 缓存模式
        web.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        // 特别注意：5.1以上默认禁止了https和http混用，以下方式是开启
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            web.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        try {
            myWebService = new MyWebService(this, 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        web.loadUrl("http://localhost:8080/index_mobile.html");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (myWebService != null) {
            myWebService.closeAllConnections();
            myWebService = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
