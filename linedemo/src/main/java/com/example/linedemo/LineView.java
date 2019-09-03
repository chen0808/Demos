package com.example.linedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class LineView extends View {

    private Paint paint;
    private int xDown;
    private int yDown;
    private int xMove;
    private int yMove;
    private boolean isMove = false;
    private boolean isDrawTower = false;
    private boolean isDrawLine = false;
    private boolean isSaveLine = false;
    private boolean isSaveTower = false;
    private int towerX;
    private int towerY;
    private List<LineList> lineList = new ArrayList<>();
    private List<TowerList> towerList = new ArrayList();
    private Bitmap bitmap;
    private int towerWidth;
    private int towerHeight;

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(5.0f);
        paint.setStyle(Paint.Style.FILL);
    }

    public void setBlackColor() {
        paint.setColor(Color.BLACK);
        isDrawLine = true;
        isDrawTower = false;
    }

    public void setRedColor() {
        paint.setColor(Color.RED);
        isDrawLine = true;
        isDrawTower = false;
    }

    public void addTower() {
        isDrawLine = false;
        isDrawTower = true;
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tower);
        towerWidth = bitmap.getWidth();
        towerHeight = bitmap.getHeight();
    }

    public void addTower2() {
        isDrawLine = false;
        isDrawTower = true;
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tower2);
        towerWidth = bitmap.getWidth();
        towerHeight = bitmap.getHeight();
    }

    public void saveLine() {
        isSaveLine = true;
        invalidate();
    }

    public void saveTower() {
        isSaveTower = true;
        invalidate();
    }


    public void clear() {

    }

    public void clearAll() {

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isMove) {//防止箭头在还没开始画的时候就在左上角出现
            //绘制保存的线路
            for (int i = 0; i < lineList.size(); i++) {
                Paint paint1 = new Paint();
                paint1.setStrokeWidth(5.0f);
                paint1.setStyle(Paint.Style.FILL);
                paint1.setColor(lineList.get(i).getColor());
                canvas.drawLine(lineList.get(i).getStartX(), lineList.get(i).getStartY(), lineList.get(i).getStopX(), lineList.get(i).getStopY(), paint1);
                canvas.drawPath(lineList.get(i).getPath(), paint1);
            }
            //绘制保存的杆塔
            for (int i = 0; i < towerList.size(); i++) {
                canvas.drawBitmap(towerList.get(i).getBitmap(), towerList.get(i).getX(), towerList.get(i).getY(), paint);
            }
            //添加线路
            if (isDrawLine) {
                drawArrow(canvas, xDown, yDown, xMove, yMove);
            }
            //添加杆塔
            if (isDrawTower && (towerX != 0 || towerY != 0)) {
                drawTower(canvas);
            }
        }
    }

    private void drawTower(Canvas canvas) {
        if (Math.abs(lineList.get(lineList.size() - 1).getStartX() - lineList.get(lineList.size() - 1).getStopX()) > Math.abs(lineList.get(lineList.size() - 1).getStartY() - lineList.get(lineList.size() - 1).getStopY())) {
            canvas.drawBitmap(bitmap, xMove - towerWidth / 2, towerY - towerHeight / 2, paint);
            if (isSaveTower) {
                towerList.add(new TowerList(bitmap, xMove - towerWidth / 2, towerY - towerHeight / 2));
            }
        } else {
            canvas.drawBitmap(bitmap, towerX - towerWidth / 2, yMove - towerHeight / 2, paint);
            if (isSaveTower) {
                towerList.add(new TowerList(bitmap, towerX - towerWidth / 2, yMove - towerHeight / 2));
            }
        }
        isSaveTower = false;
    }

    private void drawArrow(Canvas canvas, int xDown, int yDown, int xMove, int yMove) {
        if (Math.abs(yDown - yMove) < Math.abs(xDown - xMove)) {//横向
            canvas.drawLine(xDown, yDown, xMove, yDown, paint);
            towerY = yDown;
            if (xDown < xMove) {//从左到右
                Path path = new Path();
                path.moveTo(xMove + 50, yDown);
                path.lineTo(xMove, yDown + 20);
                path.lineTo(xMove, yDown - 20);
                canvas.drawPath(path, paint);
                if (isSaveLine) {
                    lineList.add(new LineList(xDown, yDown, xMove, yDown, path, paint.getColor()));
                }
            } else {//从右到左
                Path path = new Path();
                path.moveTo(xMove - 50, yDown);
                path.lineTo(xMove, yDown + 20);
                path.lineTo(xMove, yDown - 20);
                canvas.drawPath(path, paint);
                if (isSaveLine) {
                    lineList.add(new LineList(xDown, yDown, xMove, yDown, path, paint.getColor()));
                }
            }
        } else {//纵向
            canvas.drawLine(xDown, yDown, xDown, yMove, paint);
            towerX = xDown;
            if (yDown < yMove) {//从上到下
                Path path = new Path();
                path.moveTo(xDown, yMove + 50);
                path.lineTo(xDown + 20, yMove);
                path.lineTo(xDown - 20, yMove);
                canvas.drawPath(path, paint);
                if (isSaveLine) {
                    lineList.add(new LineList(xDown, yDown, xDown, yMove, path, paint.getColor()));
                }
            } else {//从下到上
                Path path = new Path();
                path.moveTo(xDown, yMove - 50);
                path.lineTo(xDown + 20, yMove);
                path.lineTo(xDown - 20, yMove);
                canvas.drawPath(path, paint);
                if (isSaveLine) {
                    lineList.add(new LineList(xDown, yDown, xDown, yMove, path, paint.getColor()));
                }
            }
        }
        isSaveLine = false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //每次回调onTouchEvent的时候，我们获取触摸点的代码
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 记录触摸点坐标
                isMove = false;
                xDown = x;
                yDown = y;
                Log.e("TAG", "LinearLayout onTouchEvent 按住");
                break;
            case MotionEvent.ACTION_MOVE:
                isMove = true;
                xMove = x;
                yMove = y;
                invalidate();
                Log.e("TAG", "LinearLayout onTouchEvent 移动");
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
