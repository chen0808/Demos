package com.example.chartdemo.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.chartdemo.R;
import com.example.chartdemo.adapter.ChartAdapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends Activity {

    private String[] type = {"LineChart", "BarChart", "HorizontalBarChart", "CombinedChart（综合）", "PieChart", "ScatterChart", "CandleStickChart(K线图)", "BubbleChart", "RadarChart"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ChartAdapter(type, this));
    }
}
