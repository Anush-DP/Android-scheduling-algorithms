package com.anush.cpusavisual.visualize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.anush.cpusavisual.EnterProcessActivity;
import com.anush.cpusavisual.Process;
import com.anush.cpusavisual.R;

import java.util.List;

public class VisualizeFCFSActivity extends AppCompatActivity {


    final int textSize=16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualize_fcfs);

        for(Process p : EnterProcessActivity.processList)
        {
            Log.i(p.getProcessName(),"AT: "+p.getArrivalTime()+" BT: "+p.getBurstTime().toString());
        }
        createInputForm();
    }

    public void createInputForm(){
        TableLayout stk = findViewById(R.id.fcfs_table);
        TableRow tbrow0 = new TableRow(this);
        TextView tv0 = new TextView(this);
        tv0.setText("Process  ");
        tv0.setTypeface(null, Typeface.BOLD);
        tv0.setTextSize(textSize);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setTypeface(null,Typeface.BOLD);
        tv1.setText("  Arrival Time(ms)  ");
        tv1.setTextSize(textSize);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setTypeface(null,Typeface.BOLD);
        tv2.setText("  Burst Time(ms)  ");
        tv2.setTextSize(textSize);
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(this);
        tv3.setTypeface(null,Typeface.BOLD);
        tv3.setText("  Wait Time(ms)  ");
        tv3.setTextSize(textSize);
        tbrow0.addView(tv3);
        TextView tv4 = new TextView(this);
        tv4.setTypeface(null,Typeface.BOLD);
        tv4.setText("  Response Time(ms)  ");
        tv4.setTextSize(textSize);
        tbrow0.addView(tv4);
        TextView tv5 = new TextView(this);
        tv5.setTypeface(null,Typeface.BOLD);
        tv5.setText("  Turnaround Time(ms)");
        tv5.setTextSize(textSize);
        tbrow0.addView(tv5);
        stk.addView(tbrow0);
        for(Process p : EnterProcessActivity.processList) {
            TableRow tbrow = new TableRow(this);
            TextView pname = new TextView(this);
            pname.setText("   "+p.getProcessName());
            pname.setTextSize(textSize);
            tbrow.addView(pname);
            TextView at = new TextView(this);
            at.setText("   "+p.getArrivalTime().toString());
            at.setTextSize(textSize);
            tbrow.addView(at);
            TextView bt = new TextView(this);
            bt.setText("   "+p.getBurstTime().toString());
            bt.setTextSize(textSize);
            tbrow.addView(bt);
            TextView wt = new TextView(this);
            wt.setText("   "+p.getWaitTime().toString());
            wt.setTextSize(textSize);
            tbrow.addView(wt);
            TextView rt = new TextView(this);
            rt.setText("   "+p.getResponseTime().toString());
            rt.setTextSize(textSize);
            tbrow.addView(rt);
            TextView tt = new TextView(this);
            tt.setText("   "+p.getTurnAroundTime().toString());
            tt.setTextSize(textSize);
            tbrow.addView(tt);
            stk.addView(tbrow);
        }
    }
}