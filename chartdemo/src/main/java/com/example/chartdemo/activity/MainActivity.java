package com.example.chartdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chartdemo.R;
import com.example.chartdemo.adapter.ChartAdapter;

public class MainActivity extends AppCompatActivity {

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
