package com.example.kurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ImageView gotomenu2 = (ImageView) findViewById(R.id.menugo1);
        gotomenu2.setOnClickListener(this);
        ImageView gotoadd1 = (ImageView) findViewById(R.id.addDoxod1);
        gotoadd1.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.menugo1:
                intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.addDoxod1:
                intent = new Intent(MainActivity3.this, MainActivity5.class);
                startActivity(intent);

        }
    }
}