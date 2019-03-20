package com.example.chartdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chartdemo.R;
import com.github.mikephil.charting.charts.CandleStickChart;

import androidx.annotation.Nullable;

public class CandleStickChartActivity extends Activity {

    private CandleStickChart candleStickChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String type = getIntent().getStringExtra("type");
        setContentView(R.layout.activity_candle_stick_chart);
        TextView title = findViewById(R.id.title);
        title.setText(type);
        candleStickChart = findViewById(R.id.candle_stick_chart);
    }
}
