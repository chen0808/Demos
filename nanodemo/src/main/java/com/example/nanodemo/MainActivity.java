package com.example.nanodemo;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "http://localhost:8080/";
    private static final String TAG = "MyWebService";
    private MyWebService myWebService;
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.web);
        web.getSettings().setUseWideViewPort(true);
        web.getSettings().setLoadWithOverviewMode(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            myWebService = new MyWebService(this, 8080);
            Log.d(TAG, "WebServer started");
//            web.loadUrl(URL);
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "WebServer start failed:" + e.getMessage());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (myWebService != null) {
            myWebService.closeAllConnections();
            myWebService = null;
            Log.d(TAG, "app pause, so web server close");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
