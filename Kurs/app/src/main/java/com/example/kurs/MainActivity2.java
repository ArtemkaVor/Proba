package com.example.kurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView gotomenu = (ImageView) findViewById(R.id.menugo);
        gotomenu.setOnClickListener(this);
        ImageView gotoadd = (ImageView) findViewById(R.id.addDoxod);
        gotoadd.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.menugo:
                intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.addDoxod:
                intent = new Intent (MainActivity2.this, MainActivity4.class);
                startActivity(intent);

        }
    }
}