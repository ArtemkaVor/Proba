package com.example.kurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView doxodgo = (TextView) findViewById(R.id.doxod);
        doxodgo.setOnClickListener(this);
        TextView rashodgo = (TextView) findViewById(R.id.Rashod);
        rashodgo.setOnClickListener(this);

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