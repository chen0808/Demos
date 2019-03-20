package com.example.chartdemo.activity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chartdemo.R;
import com.example.chartdemo.formatter.XAxisValueFormatter;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class LineChartActivity extends Activity implements OnChartValueSelectedListener {

    private TextView title;
    private LineChart lineChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String type = getIntent().getStringExtra("type");
        setContentView(R.layout.activity_line_chart);
        title = findViewById(R.id.title);
        lineChart = findViewById(R.id.line_chart);
        title.setText(type);
        initLineChart();
    }

    /**
     * 初始化折线图控件属性
     */
    private void initLineChart() {
        lineChart.setOnChartValueSelectedListener(this);//设置点击监听
        lineChart.setBackgroundColor(Color.WHITE);//背景颜色

        Description desc = new Description();//设置图表说明,可设置文字，位置，对齐方式,是否显示
        desc.setEnabled(true);
        desc.setText("折线图");
        desc.setTextAlign(Paint.Align.RIGHT);
        lineChart.setDescription(desc);

        lineChart.setTouchEnabled(true);//能否点击
        lineChart.setDragEnabled(true);//能否拖动
        lineChart.setScaleEnabled(true);//能否缩放
        lineChart.setDoubleTapToZoomEnabled(true);//双击缩放
//        lineChart.setMarker(marker);//设置标记（点击对应点显示对应描述）
//        lineChart.setRenderer(renderer);//设置渲染器，可对绘制过程进行操作

//        //自定义适配器，适配于X轴
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setAvoidFirstLastClipping(true);//是否避免图表或屏幕的边缘的第一个和最后一个轴中的标签条目被裁减
        xAxis.setLabelRotationAngle(30f);//设置绘制X轴标签的角度，以度为单位
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置xAxis应该出现的位置
        xAxis.setDrawGridLines(false);//隐藏竖线
        xAxis.setLabelCount(8, true);//设置横坐标个数，是否强制
        xAxis.setGranularity(2f);//设置相邻横坐标之间的数字间隔
        xAxis.setAxisMinimum(0);//设置横坐标最小值，为0即从0开始
        IAxisValueFormatter xAxisFormatter = new XAxisValueFormatter();//自定义横坐标
        xAxis.setValueFormatter(xAxisFormatter);
//
//        //自定义适配器，适配于Y轴
//        IAxisValueFormatter custom = new MyAxisValueFormatter();
//        YAxis leftAxis = lineChart.getAxisLeft();
////        leftAxis.setTypeface(mTfLight);
//        leftAxis.setLabelCount(8, false);
//        leftAxis.setValueFormatter(custom);
//        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
//        leftAxis.setSpaceTop(15f);
//        leftAxis.setAxisMinimum(0f);

        lineChart.getAxisRight().setEnabled(false);

        setLineChartData();
    }

    private float getRandom(float range, float startsfrom) {
        return (float) (Math.random() * range) + startsfrom;
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    /**
     * 设置折线图的数据
     */
    private void setLineChartData() {
        //填充数据，在这里换成自己的数据源
        List<Entry> valsComp1 = new ArrayList<>();
        List<Entry> valsComp2 = new ArrayList<>();
        List<Entry> valsComp3 = new ArrayList<>();

        valsComp1.add(new Entry(0, 2));
        valsComp1.add(new Entry(1, 4));
        valsComp1.add(new Entry(2, 0));
        valsComp1.add(new Entry(3, 2));
        valsComp1.add(new Entry(4, 2));
        valsComp1.add(new Entry(5, 4));
        valsComp1.add(new Entry(6, 0));
        valsComp1.add(new Entry(7, 2));

        valsComp2.add(new Entry(0, 2));
        valsComp2.add(new Entry(1, 0));
        valsComp2.add(new Entry(2, 4));
        valsComp2.add(new Entry(3, 2));
        valsComp2.add(new Entry(4, 2));
        valsComp2.add(new Entry(5, 0));
        valsComp2.add(new Entry(6, 4));
        valsComp2.add(new Entry(7, 2));

        valsComp3.add(new Entry(0, 1));
        valsComp3.add(new Entry(1, 4));
        valsComp3.add(new Entry(2, 2));
        valsComp3.add(new Entry(3, 3));
        valsComp3.add(new Entry(4, 1));
        valsComp3.add(new Entry(5, 4));
        valsComp3.add(new Entry(6, 2));
        valsComp3.add(new Entry(7, 3));

        //这里，每重新new一个LineDataSet，相当于重新画一组折线
        //每一个LineDataSet相当于一组折线。比如:这里有两个LineDataSet：setComp1，setComp2。
        //则在图像上会有两条折线图，分别表示公司1 和 公司2 的情况.还可以设置更多
        LineDataSet setComp1 = new LineDataSet(valsComp1, "Company 1 ");
        setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
        setComp1.setColor(Color.BLUE);//设置线条颜色
        setComp1.setLineWidth(1f);//设置线条宽度
        setComp1.setDrawValues(true);//设置是否显示点上的数值
        setComp1.setHighLightColor(Color.GREEN);//设置高亮颜色
        setComp1.setDrawCircles(true);//是否显示点对应的圆
        setComp1.setCircleRadius(10f);//设置圆外圈半径
        setComp1.setCircleColor(Color.parseColor("#aabbcc"));//设置圆外圈颜色
        setComp1.setCircleHoleRadius(5f);//设置内圈圆半径
        setComp1.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);//设置模式（曲线2种，直线2种）

        LineDataSet setComp2 = new LineDataSet(valsComp2, "Company 2 ");
        setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
        setComp2.setDrawCircles(true);
        setComp2.setColor(Color.RED);
        setComp2.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);

        LineDataSet setComp3 = new LineDataSet(valsComp3, "Company 3 ");
        setComp3.setAxisDependency(YAxis.AxisDependency.LEFT);
        setComp3.setDrawCircles(true);
        setComp3.setColor(Color.YELLOW);
        setComp3.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);

        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(setComp1);
//        dataSets.add(setComp2);
//        dataSets.add(setComp3);

        LineData lineData = new LineData(dataSets);

        lineChart.setData(lineData);
        lineChart.invalidate();//如果使用了动画就无须使用
    }
}
