package com.anush.cpusavisual.visualize;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class GanttChartView extends View {
    Paint paint = null;
    public GanttChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }
//    public GanttChartView(Context context)
//    {
//        super(context);
//        paint = new Paint();
//    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int x = getWidth();
        int y = getHeight();
        int radius;
        radius = 100;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.DKGRAY);
        canvas.drawPaint(paint);
        // Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#CD5C5C"));
        canvas.drawCircle(x /2, y/2 , y/2, paint);
        // canvas.drawRect(x-x/3,y-y/3,x-x/2,y-y/2,paint);
    }
}
