package com.example.chartdemo.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chartdemo.R;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class BubbleChartActivity extends Activity {

    private BubbleChart bubbleChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String type = getIntent().getStringExtra("type");
        setContentView(R.layout.activity_bubble_chart);
        TextView title = findViewById(R.id.title);
        title.setText(type);
        bubbleChart = findViewById(R.id.bubble_chart);

        int count = 10;
        int range = 100;

        ArrayList<BubbleEntry> yVals = new ArrayList<BubbleEntry>();

        ArrayList<BubbleEntry> yVals_blue = new ArrayList<BubbleEntry>();
        ArrayList<BubbleEntry> yVals_yellow = new ArrayList<BubbleEntry>();
        ArrayList<BubbleEntry> yVals_red = new ArrayList<BubbleEntry>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range);
            yVals.add(new BubbleEntry(i + 1, val, val));
        }

        for (int i = 0; i < yVals.size(); i++) {
            BubbleEntry bubbleEntry = yVals.get(i);
            if (bubbleEntry.getY() <= 100 / 3) {
                yVals_red.add(bubbleEntry);
            } else if (bubbleEntry.getY() > 100 / 3 && bubbleEntry.getY() <= 200 / 3) {
                yVals_yellow.add(bubbleEntry);
            } else if (bubbleEntry.getY() > 200 / 3) {
                yVals_blue.add(bubbleEntry);
            }
        }


        BubbleDataSet set1 = new BubbleDataSet(yVals_blue, "优秀");
        set1.setDrawIcons(false);
        set1.setColor(Color.BLUE, 100);
        set1.setDrawValues(true);

        BubbleDataSet set2 = new BubbleDataSet(yVals_yellow, "良好");
        set2.setDrawIcons(false);
        set2.setColor(Color.YELLOW, 100);
        set2.setDrawValues(true);

        BubbleDataSet set3 = new BubbleDataSet(yVals_red, "很差");
        set3.setDrawIcons(false);
        set3.setColor(Color.RED, 100);
        set3.setDrawValues(true);

        ArrayList<IBubbleDataSet> dataSets = new ArrayList<IBubbleDataSet>();
        dataSets.add(set1);
        dataSets.add(set2);
        dataSets.add(set3);
        BubbleData data = new BubbleData(dataSets);
        data.setDrawValues(true);
        data.setValueTextSize(14f);
        data.setValueTextColor(Color.BLACK);
        data.setHighlightCircleWidth(1.5f);
        bubbleChart.setData(data);
        bubbleChart.invalidate();
    }
}
