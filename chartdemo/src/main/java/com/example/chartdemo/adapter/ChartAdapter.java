package com.example.chartdemo.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.chartdemo.R;
import com.example.chartdemo.activity.BarChartActivity;
import com.example.chartdemo.activity.BubbleChartActivity;
import com.example.chartdemo.activity.CandleStickChartActivity;
import com.example.chartdemo.activity.CombinedChartActivity;
import com.example.chartdemo.activity.HorizontalBarChartActivity;
import com.example.chartdemo.activity.LineChartActivity;
import com.example.chartdemo.activity.PieChartActivity;
import com.example.chartdemo.activity.RadarChartActivity;
import com.example.chartdemo.activity.ScatterChartActivity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChartAdapter extends RecyclerView.Adapter<ChartAdapter.VH> {

    private final String[] type;
    private final Activity activity;

    public ChartAdapter(String[] type, Activity activity) {
        this.type = type;
        this.activity = activity;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, final int i) {
        vh.btn.setText(type[i]);
        vh.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("type", type[i]);
                switch (i) {
                    case 0:
                        intent.setClass(activity, LineChartActivity.class);
                        break;
                    case 1:
                        intent.setClass(activity, BarChartActivity.class);
                        break;
                    case 2:
                        intent.setClass(activity, HorizontalBarChartActivity.class);
                        break;
                    case 3:
                        intent.setClass(activity, CombinedChartActivity.class);
                        break;
                    case 4:
                        intent.setClass(activity, PieChartActivity.class);
                        break;
                    case 5:
                        intent.setClass(activity, ScatterChartActivity.class);
                        break;
                    case 6:
                        intent.setClass(activity, CandleStickChartActivity.class);
                        break;
                    case 7:
                        intent.setClass(activity, BubbleChartActivity.class);
                        break;
                    case 8:
                        intent.setClass(activity, RadarChartActivity.class);
                        break;
                }
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return type.length;
    }


    public static class VH extends RecyclerView.ViewHolder {
        public static Button btn;

        public VH(View v) {
            super(v);
            btn = v.findViewById(R.id.btn);
        }
    }
}
