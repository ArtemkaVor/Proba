package com.example.a27;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnsign_in;
    ImageView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView buttonBack = (TextView) findViewById(R.id.txtgo);
        button = (ImageView) findViewById(R.id.button);
        buttonBack.setOnClickListener(this);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.txtgo:
                intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.button:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA));
                startActivity(intent);

        }
    }


}

