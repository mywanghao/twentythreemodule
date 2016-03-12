package com.example.hao.twenty_three_module.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by hao on 2016/3/12.
 * 弹弹球
 */
public class BouncyBallView extends View {


    private  Paint paint;
    private Context context;

    public int getBouncyBallColor() {
        return bouncyBallColor;
    }

    public void setBouncyBallColor(int bouncyBallColor) {
        this.bouncyBallColor = bouncyBallColor;
        invalidate();
    }

    private int bouncyBallColor = Color.RED;


    public BouncyBallView(Context context) {
        super(context);
    }

    public BouncyBallView(Context context, AttributeSet attrs) {
        super(context, attrs);


        this.context = context ;
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
       // this.paint.setStyle(Paint.Style.FILL);
    }

    public BouncyBallView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int center = getWidth()/2;
        int innerCircle = dip2px(context,83);
        int ringWidth = dip2px(context,5);

        //绘制内圆
        this.paint.setColor(bouncyBallColor);

        canvas.drawCircle(center,center, center, this.paint);

        Log.e("TAA","ondrow重绘");

    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
