package com.example.gallerydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    private static final String TAG = "MainActivity";
    private int index = 0;
    private ViewFlipper vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vf = findViewById(R.id.vf);

        TranslateAnimation inAnim = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inAnim.setDuration(1000);

        TranslateAnimation outAnim = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outAnim.setDuration(1000);

        vf.setInAnimation(inAnim);
        vf.setOutAnimation(outAnim);

        vf.setFlipInterval(2000);
        vf.getInAnimation().setAnimationListener(this);
        vf.startFlipping();
    }

    @Override
    public void onAnimationStart(Animation animation) {
        Log.d(TAG, "onAnimationStart: ");
        vf.getChildAt(index % 4).setScaleX(0.8f);
        vf.getChildAt(index % 4).setScaleY(0.8f);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Log.d(TAG, "onAnimationEnd: ");
        vf.getChildAt(index % 4).setScaleX(1f);
        vf.getChildAt(index % 4).setScaleY(1f);
        index++;
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        Log.d(TAG, "onAnimationRepeat: ");
    }
}
