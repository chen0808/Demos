package com.example.linedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LineView lineVIew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button black = findViewById(R.id.btn_black);
        Button red = findViewById(R.id.btn_red);
        Button saveLine = findViewById(R.id.btn_save_line);
        Button tower = findViewById(R.id.btn_tower);
        Button tower2 = findViewById(R.id.btn_tower2);
        Button saveTower = findViewById(R.id.btn_save_tower);
        Button clear = findViewById(R.id.btn_clear);
        Button clearAll = findViewById(R.id.btn_clear_all);
        lineVIew = findViewById(R.id.line_view);
        black.setOnClickListener(this);
        red.setOnClickListener(this);
        saveLine.setOnClickListener(this);
        tower.setOnClickListener(this);
        tower2.setOnClickListener(this);
        saveTower.setOnClickListener(this);
        clear.setOnClickListener(this);
        clearAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_black:
                lineVIew.setBlackColor();
                break;
            case R.id.btn_red:
                lineVIew.setRedColor();
                break;
            case R.id.btn_save_line:
                lineVIew.saveLine();
                break;
            case R.id.btn_tower:
                lineVIew.addTower();
                break;
            case R.id.btn_tower2:
                lineVIew.addTower2();
                break;
            case R.id.btn_save_tower:
                lineVIew.saveTower();
                break;
            case R.id.btn_clear:
                lineVIew.clear();
                break;
            case R.id.btn_clear_all:
                lineVIew.clearAll();
                break;
        }
    }
}
