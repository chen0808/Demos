package com.example.pgisdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.circlelibary.CircleView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CircleView mCircleView;
    private Button mFlyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCircleView = findViewById(R.id.circle_view);
        mFlyBtn = (Button) findViewById(R.id.fly_btn);

        mFlyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCircleView.click();
            }
        });
    }


    //销毁Webview
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCircleView.destory();
    }
}
