package com.example.chartdemo.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chartdemo.R;
import com.example.chartdemo.formatter.MyAxisValueFormatter;
import com.example.chartdemo.formatter.XAxisValueFormatter;
import com.example.chartdemo.view.XYMarkerView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class BarChartActivity extends Activity implements OnChartValueSelectedListener {

    private String[] mMonths = new String[]{
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"};
    private String[] mParties = new String[]{
            "Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H",
            "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
            "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
            "Party Y", "Party Z"
    };
    private BarChart mChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String type = getIntent().getStringExtra("type");
        setContentView(R.layout.activity_bar_chart);
        TextView title = findViewById(R.id.title);
        title.setText(type);
        mChart = findViewById(R.id.bc);
        initBarChart();
    }

    /**
     * 初始化柱形图控件属性
     */
    private void initBarChart() {
        mChart.setOnChartValueSelectedListener(this);
        mChart.setDrawBarShadow(false);
        mChart.setDrawValueAboveBar(true);
        mChart.getDescription().setEnabled(false);
        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        mChart.setMaxVisibleValueCount(60);
        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(false);
        mChart.setDrawGridBackground(false);

//        IAxisValueFormatter xAxisFormatter = new DayAxisValueFormatter(mChart);

        //自定义坐标轴适配器，配置在X轴，xAxis.setValueFormatter(xAxisFormatter);
        IAxisValueFormatter xAxisFormatter = new XAxisValueFormatter();

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setTypeface(mTfLight);//可以去掉，没什么用
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(xAxisFormatter);


        //自定义坐标轴适配器，配置在Y轴。leftAxis.setValueFormatter(custom);
        IAxisValueFormatter custom = new MyAxisValueFormatter();

        //设置限制临界线
        LimitLine limitLine = new LimitLine(3f, "临界点");
        limitLine.setLineColor(Color.GREEN);
        limitLine.setLineWidth(1f);
        limitLine.setTextColor(Color.GREEN);

        //获取到图形左边的Y轴
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.addLimitLine(limitLine);
//        leftAxis.setTypeface(mTfLight);//可以去掉，没什么用
        leftAxis.setLabelCount(8, false);
        leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinimum(0f);

        //获取到图形右边的Y轴，并设置为不显示
        mChart.getAxisRight().setEnabled(false);

        //图例设置
        Legend legend = mChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setFormSize(9f);
        legend.setTextSize(11f);
        legend.setXEntrySpace(4f);

        //如果点击柱形图，会弹出pop提示框.XYMarkerView为自定义弹出框
        XYMarkerView mv = new XYMarkerView(this, xAxisFormatter);
        mv.setChartView(mChart);
        mChart.setMarker(mv);
        setBarChartData();
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    private void setBarChartData() {

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();


        //在这里设置自己的数据源,BarEntry 只接收float的参数，
        //图形横纵坐标默认为float形式，如果想展示文字形式，需要自定义适配器，
        yVals1.add(new BarEntry(0, 4));
        yVals1.add(new BarEntry(1, 2));
        yVals1.add(new BarEntry(2, 6));
        yVals1.add(new BarEntry(3, 1));


        BarDataSet set1;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "The year 2017");
            set1.setDrawIcons(false);

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
//            data.setValueTypeface(mTfLight);//可以去掉，没什么用
            data.setBarWidth(0.9f);

            mChart.setData(data);
        }
    }
}
