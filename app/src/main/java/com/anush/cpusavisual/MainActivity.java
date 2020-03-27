package com.anush.cpusavisual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner AlgoSpinner;
    EditText NoOfProcesses;
    Button OkButton;
    int nProc;
    public static final String EXTRA_NUMBER="com.anush.cpusavisual.EXTRA_NUMBER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlgoSpinner = findViewById(R.id.algo_spinner);
        AlgoSpinner.setOnItemSelectedListener(this);
        NoOfProcesses = findViewById(R.id.no_of_proc);
        OkButton = findViewById(R.id.ok_button);

        OkButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(NoOfProcesses.length()==0 || NoOfProcesses.getText().toString().charAt(0)=='0')
                {
                    NoOfProcesses.setError("Enter a valid number");
                }
                else
                {
                    nProc = Integer.parseInt(NoOfProcesses.getText().toString());
                    openEnterProcessActivity();
                }
            }
        });
    }

    private void openEnterProcessActivity() {
        Intent intent = new Intent(this,EnterProcessActivity.class);
        intent.putExtra(EXTRA_NUMBER, nProc);
        startActivity(intent);
    }

    String algos[] = {"FCFS","SJF","RR"};
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        Toast.makeText(getApplicationContext(), algos[pos], Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
