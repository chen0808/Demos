package com.example.permissiondemo;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE, Manifest.permission.INTERNET)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            Toast.makeText(MainActivity.this, "允许了权限!", Toast.LENGTH_SHORT).show();
                        } else {
                            //只要有一个权限被拒绝，就会执行
                            Toast.makeText(MainActivity.this, "未授权权限，部分功能不能使用", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
