package com.example.chartdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chartdemo.R;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class RadarChartActivity extends Activity {

    private RadarChart radarChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String type = getIntent().getStringExtra("type");
        setContentView(R.layout.activity_radar_chart);
        TextView title = findViewById(R.id.title);
        title.setText(type);
        radarChart = findViewById(R.id.radar_chart);

        XAxis xAxis = radarChart.getXAxis();
        YAxis yAxis = radarChart.getYAxis();
        yAxis.setAxisMinimum(0);
        List<RadarEntry> radarEntries = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            radarEntries.add(new RadarEntry((i + 1) * 10));
        }
        RadarDataSet dataSet = new RadarDataSet(radarEntries, "");
        RadarData radarData = new RadarData(dataSet);
        radarChart.animateXY(1000, 1000);
        radarChart.setData(radarData);
        radarChart.invalidate();
    }
}
