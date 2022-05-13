package com.example.kurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {
    private TextView ptvsumm, ptvcomm, ptvdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        init();
        getIntentMain();
    }
    private void init(){
        ptvsumm = findViewById(R.id.tvsummshow);
        ptvcomm = findViewById(R.id.tvcommshow);
        ptvdate = findViewById(R.id.tvdateshow);

    }
    private void getIntentMain(){
        Intent i = getIntent();
        if(i !=null)
        {
            ptvsumm.setText(i.getStringExtra("summ_show"));
            ptvcomm.setText(i.getStringExtra("comm_show"));
            ptvdate.setText(i.getStringExtra("date_show"));
        }
    }
}