package com.anush.cpusavisual.visualize;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.anush.cpusavisual.Process;

import java.util.Random;

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
        int y = getHeight()-50;
        int radius;
        radius = 100;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.DKGRAY);
        canvas.drawPaint(paint);
        Random rnd = new Random();
        //paint.setARGB(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        // Use Color.parseColor to define HTML colors
        //paint.setColor(Color.rgb());
        //canvas.drawCircle(x /2, y/2 , y/2, paint);
        //canvas.drawText(VisualizeFCFSActivity.chartProcesses.get(0).getProcessName(),x/2,y/2,paint);
        int size=VisualizeFCFSActivity.chartProcesses.get(VisualizeFCFSActivity.chartProcesses.size()-1).getArrivalTime();
        for(Process p:VisualizeFCFSActivity.chartProcesses) {
            if(p.getProcessName().equals("Stats")) {
                canvas.drawText(p.getBurstTime().toString(),x-28,y+50,paint);
                break;
            }
            rnd = new Random();
            paint.setARGB(255,rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            //paint.setARGB(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            canvas.drawRect(p.getArrivalTime()*x/size, 0, p.getBurstTime() * x / size, y, paint);
            paint.setColor(Color.WHITE);
            paint.setTextSize(48f);
            canvas.drawText(p.getProcessName(),(p.getArrivalTime()+p.getBurstTime())*x/(size*2),y/2,paint);
            canvas.drawText(p.getArrivalTime().toString(),p.getArrivalTime()*x/size,y+49,paint);
        }
        // canvas.drawRect(x-x/3,y-y/3,x-x/2,y-y/2,paint);
    }
}
