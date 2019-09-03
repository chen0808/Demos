package com.example.mvpdemo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 作者：陈飞
 * 时间：2019/08/26 17:03
 */
public class ToastUtils {
    public static void show(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
}
