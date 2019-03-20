package com.example.chartdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chartdemo.R;
import com.github.mikephil.charting.charts.CombinedChart;

import androidx.annotation.Nullable;

public class CombinedChartActivity extends Activity {

    private CombinedChart combindChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String type = getIntent().getStringExtra("type");
        setContentView(R.layout.activity_combind_chart);
        TextView title = findViewById(R.id.title);
        title.setText(type);
        combindChart = findViewById(R.id.combind_chart);
//        CombinedData data=new CombinedData();
//        combindChart.setData(data);
    }
}
