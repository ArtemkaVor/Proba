package com.example.kurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivityRashod extends AppCompatActivity {
    private TextView ptvsummr, ptvcommr, ptvdater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rashod);
        init();
        getIntentMain();
    }
    private void init(){
        ptvsummr = findViewById(R.id.tvsummshow);
        ptvcommr = findViewById(R.id.tvcommshow);
        ptvdater = findViewById(R.id.tvdateshow);

    }
    private void getIntentMain(){
        Intent i = getIntent();
        if(i !=null)
        {
            ptvsummr.setText(i.getStringExtra("summr_show"));
            ptvcommr.setText(i.getStringExtra("commr_show"));
            ptvdater.setText(i.getStringExtra("dater_show"));
        }
    }
}