package com.anush.cpusavisual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


import com.anush.cpusavisual.visualize.VisualizeFCFSActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnterProcessActivity extends AppCompatActivity {

    public static List<Process> processList;
    List<TextView> processNameList;
    public static final String processName="P";
    public static final String ONE="1";
    public static final String EXTRA_PROCESS_LIST = "com";
    Integer numberOfProcesses;
    List<EditText> processArrivalTime,processBurstTime;
    Button visualizeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_enter_process);
        numberOfProcesses = intent.getIntExtra(MainActivity.EXTRA_NUMBER,1);
        processList = new ArrayList<>();
        processNameList = new ArrayList<>();
        processArrivalTime = new ArrayList<>();
        processBurstTime = new ArrayList<>();
        visualizeButton = findViewById(R.id.visualize_button);

        for (int i=0; i<numberOfProcesses; ++i) {
            processList.add(new Process());
            processNameList.add(i, new TextView(this));
            processNameList.get(i).setText(processName+(i+1));
            processArrivalTime.add(i, new EditText(this));
            processArrivalTime.get(i).setInputType(InputType.TYPE_CLASS_NUMBER);
            processArrivalTime.get(i).setText(""+i);
            processBurstTime.add(i, new EditText(this));
            processBurstTime.get(i).setInputType(InputType.TYPE_CLASS_NUMBER);
            processBurstTime.get(i).setText(ONE);
        }

        visualizeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                boolean inputErrorFlag=false;
                for(EditText et: processBurstTime)
                {
                    if(et.getText().toString().isEmpty() || et.getText().toString().charAt(0)=='0')
                    {
                        et.setError("Enter valid burst time");
                        inputErrorFlag=true;
                        break;
                    }
                }
                if(!inputErrorFlag){
                updateProcesses();
                openVisualizeActivity();}
            }
        });

        createInputForm();
    }

    private void updateProcesses() {
        for(int i=0; i<numberOfProcesses; ++i)
        {
            processList.get(i).setArrivalTime(Integer.parseInt(processArrivalTime.get(i).getText().toString()));
            processList.get(i).setBurstTime(Integer.parseInt(processBurstTime.get(i).getText().toString()));
            processList.get(i).setProcessName(processNameList.get(i).getText().toString());
        }
        Collections.sort(processList, new Comparator<Process>() {

            public int compare(Process p1, Process p2) {
                return p1.getArrivalTime().compareTo(p2.getArrivalTime());
            }
        });
    }
    private void openVisualizeActivity() {
        Intent intent = new Intent(this, VisualizeFCFSActivity.class);
        intent.putExtra(EXTRA_PROCESS_LIST,numberOfProcesses);
        startActivity(intent);
    }

    public void createInputForm(){
        TableLayout stk = findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);
        TextView tv0 = new TextView(this);
        tv0.setText("Process  ");
        tv0.setTypeface(null,Typeface.BOLD);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setTypeface(null,Typeface.BOLD);
        tv1.setText("  Arrival Time(ms)  ");
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setTypeface(null,Typeface.BOLD);
        tv2.setText("  Burst Time(ms)  ");
        tbrow0.addView(tv2);
        stk.addView(tbrow0);
        for (int i = 0; i < numberOfProcesses; i++) {
            TableRow tbrow = new TableRow(this);
            tbrow.addView(processNameList.get(i));
            tbrow.addView(processArrivalTime.get(i));
            tbrow.addView(processBurstTime.get(i));
            stk.addView(tbrow);
        }
    }
}
