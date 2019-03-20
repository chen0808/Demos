package com.example.chartdemo.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chartdemo.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class PieChartActivity extends Activity {

    private PieChart pieChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String type = getIntent().getStringExtra("type");
        setContentView(R.layout.activity_pie_chart);
        TextView title = findViewById(R.id.title);
        title.setText(type);
        pieChart = findViewById(R.id.pie_chart);

        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(18.5f, "Green"));
        entries.add(new PieEntry(26.7f, "Yellow"));
        entries.add(new PieEntry(24.0f, "Red"));
        entries.add(new PieEntry(30.8f, "Blue"));

        PieDataSet set = new PieDataSet(entries, "Election Results");
        int[] colors = {Color.GREEN, Color.YELLOW, Color.RED, Color.BLUE};
        set.setColors(colors);
        PieData data = new PieData(set);
        pieChart.setData(data);
        pieChart.invalidate(); // refresh
    }
}
