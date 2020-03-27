package com.anush.cpusavisual;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class EnterProcessActivity extends AppCompatActivity {

    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_process);

        Intent intent = getIntent();
        Integer n = intent.getIntExtra(MainActivity.EXTRA_NUMBER,1);

        LinearLayout linearLayout = findViewById(R.id.vla);

        TextView tv = new TextView(this);
        tv.setText("Process Name");
        tv.setLayoutParams( new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(tv);
        TextView tv1 = new TextView(this);
        tv.setText("Arrival Time");
        tv.setLayoutParams( new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(tv1);

    }

}
