package com.example.chartdemo;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class BarChart extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_bar_chart);
    }
}
