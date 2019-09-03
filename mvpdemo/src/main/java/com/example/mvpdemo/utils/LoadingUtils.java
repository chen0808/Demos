package com.example.mvpdemo.utils;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.wang.avi.AVLoadingIndicatorView;
import com.wang.avi.Indicator;

/**
 * 作者：陈飞
 * 时间：2019/08/26 17:11
 */
public class LoadingUtils {
    private static AVLoadingIndicatorView avi;

    public static void init(Context context) {

    }

    ;

    public static void show(Context context, Indicator indicator) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        avi = new AVLoadingIndicatorView(context);
        ViewGroup.LayoutParams params = new WindowManager.LayoutParams();
        params.height = 160;
        params.width = 160;
        ((WindowManager.LayoutParams) params).format = PixelFormat.TRANSLUCENT;
        windowManager.addView(avi, params);
        avi.setIndicator(indicator);
        avi.show();
    }

    public static void hide() {
        if (avi != null) {
            avi.hide();
        }
    }
}
