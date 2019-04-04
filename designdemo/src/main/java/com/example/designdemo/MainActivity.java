package com.example.designdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.CompoundButton;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout freshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SwitchCompat mSwitchCompat = findViewById(R.id.switch_compat);
//        mSwitchCompat.setError("错误");      //设置错误信息的显示
//        mSwitchCompat.setTextOff("off");     //设置关闭时的文字
//        mSwitchCompat.setTextOn("on");       //设置打开时的文字
//        mSwitchCompat.setShowText(true);     //设置是否显示文字
//        mSwitchCompat.setSwitchPadding(100);  //设置文字与开关的间隙
//        mSwitchCompat.setChecked(true);      //设置是否是选中(打开)状态
        mSwitchCompat.setOnCheckedChangeListener(this);  //设置打开关闭监听
//        freshLayout = findViewById(R.id.fresh_layout);
//        freshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
//                android.R.color.holo_green_light, android.R.color.holo_orange_light);
//        freshLayout.setOnRefreshListener(this);
        CollapsingToolbarLayout ctbl = findViewById(R.id.ctbl);
        ctbl.setTitle("CollapsingToolbarLayout");
        //通过CollapsingToolbarLayout修改字体颜色
        ctbl.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        ctbl.setCollapsedTitleTextColor(Color.GREEN);//设置收缩后Toolbar上字体的颜色
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Snackbar.make(buttonView, "谢谢浏览我的博客", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        freshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
}
