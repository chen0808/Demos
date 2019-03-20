package com.example.chartdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chartdemo.R;
import com.example.chartdemo.formatter.DecimalFormatter;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class HorizontalBarChartActivity extends Activity implements OnChartValueSelectedListener {

    private TextView title;
    private HorizontalBarChart hBarChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String type = getIntent().getStringExtra("type");
        setContentView(R.layout.activity_horizontal_bar_chart);
        title = findViewById(R.id.title);
        hBarChart = findViewById(R.id.h_bar_chart);
        title.setText(type);
        initHBarChart();
    }

    /**
     * 初始化水平柱形图图控件属性
     */
    private void initHBarChart() {
        hBarChart.setOnChartValueSelectedListener(this);
        hBarChart.setDrawBarShadow(false);
        hBarChart.setDrawValueAboveBar(true);
        hBarChart.getDescription().setEnabled(false);
        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        hBarChart.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        hBarChart.setPinchZoom(false);

        // draw shadows for each bar that show the maximum value
        // mChart.setDrawBarShadow(true);

        hBarChart.setDrawGridBackground(false);

        //自定义坐标轴适配器，设置在X轴
        DecimalFormatter formatter = new DecimalFormatter();
        XAxis xl = hBarChart.getXAxis();
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xl.setTypeface(mTfLight);
        xl.setLabelRotationAngle(-45f);
        xl.setDrawAxisLine(true);
        xl.setDrawGridLines(false);
        xl.setGranularity(1f);
//        xl.setAxisMinimum(0);
        xl.setValueFormatter(formatter);

        //对Y轴进行设置
        YAxis yl = hBarChart.getAxisLeft();
//        yl.setTypeface(mTfLight);
        yl.setDrawAxisLine(true);
        yl.setDrawGridLines(true);
        yl.setAxisMinimum(0f); // this replaces setStartAtZero(true)
//        yl.setInverted(true);

        hBarChart.getAxisRight().setEnabled(false);

        //图例设置
        Legend l = hBarChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setFormSize(8f);
        l.setXEntrySpace(4f);

        setHBarChartData();
        hBarChart.setFitBars(true);
        hBarChart.animateY(2500);
    }

    /**
     * 设置水平柱形图数据的方法
     */
    private void setHBarChartData() {
        //填充数据，在这里换成自己的数据源
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        yVals1.add(new BarEntry(0, 4));
        yVals1.add(new BarEntry(1, 2));
        yVals1.add(new BarEntry(2, 6));
        yVals1.add(new BarEntry(3, 1));
        BarDataSet set1;

        if (hBarChart.getData() != null &&
                hBarChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) hBarChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            hBarChart.getData().notifyDataChanged();
            hBarChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "DataSet 1");

            set1.setDrawIcons(false);

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
//            data.setValueTypeface(mTfLight);//可以去掉，没什么用
            data.setBarWidth(0.5f);

            hBarChart.setData(data);
        }
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
