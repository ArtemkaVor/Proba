package com.example.kurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView obsummview;
    private TextView tvdoxodp;
    private double obsummp = 0;
    public double d;
    public double r;
    private String finalsumm;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obsummp = d - r;
        String finalsumm = Double.toString(obsummp);
        obsummview = findViewById(R.id.obsumm);
        obsummview.setText(finalsumm);



    }
    public void tr1()
    {
        tvdoxodp = findViewById(R.id.tvdoxodmain);
        Intent intent = getIntent();
        String name = intent.getStringExtra("doxodtr");
        tvdoxodp.setText(name);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.doxod:
                intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.Rashod:
                intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
        }
    }
}