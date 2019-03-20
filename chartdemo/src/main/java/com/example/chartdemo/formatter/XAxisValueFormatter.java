package com.example.chartdemo.formatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

public class XAxisValueFormatter implements IAxisValueFormatter {
    private String[] xStrs = new String[]{"春", "夏", "秋", "冬"};

    @Override

    public String getFormattedValue(float value, AxisBase axis) {
        int position = (int) value;
        if (position >= 4) {
            position = 0;
        }
        return xStrs[position];
    }
}
