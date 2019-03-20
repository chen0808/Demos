package com.example.layoutdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class SlashView extends View {
    private String TAG = "SlashView";

    private Paint paint;
    private int l, t, r, b;

    public SlashView(Context context) {
        this(context, null);
    }

    public SlashView(Context context, AttributeSet attrs) {
        this(context, null, 0);
    }

    public SlashView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.d(TAG, "l:" + l + "   t:" + t + "   r:" + r + "   b:" + b);
        this.l = l;
        this.t = t;
        this.r = r;
        this.b = b;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "widthMeasureSpec:" + widthMeasureSpec + "   heightMeasureSpec" + heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw" + l + t + r + b);
        canvas.drawLine(l, t, r - l, b - t, paint);
        canvas.drawLine(2 * (l + r) / 3, t, r - l, b - t, paint);
    }


}
