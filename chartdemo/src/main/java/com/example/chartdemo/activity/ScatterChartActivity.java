package com.example.chartdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chartdemo.R;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class ScatterChartActivity extends Activity {

    private ScatterChart scatterChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String type = getIntent().getStringExtra("type");
        setContentView(R.layout.activity_scatter_chart);
        TextView title = findViewById(R.id.title);
        title.setText(type);
        scatterChart = findViewById(R.id.scatter_chart);
        ArrayList<Entry> yVals1 = new ArrayList<Entry>();
        ArrayList<Entry> yVals2 = new ArrayList<Entry>();
        ArrayList<Entry> yVals3 = new ArrayList<Entry>();

        for (int i = 0; i < 10; i++) {
            float val = (float) (Math.random() * 10 + 3);
            yVals1.add(new Entry(i, val));
        }

        for (int i = 0; i < 10; i++) {
            float val = (float) (Math.random() * 10 + 3);
            yVals2.add(new Entry(i + 0.33f, val));
        }

        for (int i = 0; i < 10; i++) {
            float val = (float) (Math.random() * 10 + 3);
            yVals3.add(new Entry(i + 0.66f, val));
        }

        //创建一个数据集,并给它一个类型
        ScatterDataSet set1 = new ScatterDataSet(yVals1, "优秀");
        set1.setScatterShape(ScatterChart.ScatterShape.SQUARE);
        //设置颜色
        set1.setColor(ColorTemplate.COLORFUL_COLORS[0]);
        ScatterDataSet set2 = new ScatterDataSet(yVals2, "及格");
        set2.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
        set2.setScatterShapeHoleColor(ColorTemplate.COLORFUL_COLORS[3]);
        set2.setScatterShapeHoleRadius(3f);
        set2.setColor(ColorTemplate.COLORFUL_COLORS[1]);
        ScatterDataSet set3 = new ScatterDataSet(yVals3, "不及格");
//        set3.setShapeRenderer(new CustomScatterShapeRenderer());
        set3.setColor(ColorTemplate.COLORFUL_COLORS[2]);

        set1.setScatterShapeSize(8f);
        set2.setScatterShapeSize(8f);
        set3.setScatterShapeSize(8f);

        ArrayList<IScatterDataSet> dataSets = new ArrayList<IScatterDataSet>();
        dataSets.add(set1);
        dataSets.add(set2);
        dataSets.add(set3);

        //创建一个数据集的数据对象
        ScatterData data = new ScatterData(dataSets);

        scatterChart.setData(data);
        scatterChart.invalidate();

    }
}
