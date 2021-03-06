package com.example.kurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity5 extends AppCompatActivity implements View.OnClickListener  {
   private EditText prashodadd,pcommentradd,ptvdater;
   private DatabaseReference mDataBase;
   private String RASHOD_KEY = "Rashod";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        init();
    }
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.backrashod:
                intent = new Intent(MainActivity5.this, MainActivity3.class);
                startActivity(intent);

        }
    }

    public void init()
    {
        prashodadd = findViewById(R.id.rashodadd);
        pcommentradd = findViewById(R.id.commentradd);
        ptvdater = findViewById(R.id.tvdater);
        mDataBase = FirebaseDatabase.getInstance().getReference(RASHOD_KEY);
    }

    public void onClickSave(View View)
    {
        String id = mDataBase.getKey();
        String summ = prashodadd.getText().toString();
        String comm = pcommentradd.getText().toString();
        String date = ptvdater.getText().toString();
        Rashod newrashod = new Rashod(id,summ,comm,date);
        if (!TextUtils.isEmpty(summ))
        {
            mDataBase.push().setValue(newrashod);
            Toast.makeText(this, "Вы добавили сумму", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity5.this, MainActivity3.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "Введите сумму", Toast.LENGTH_SHORT).show();
        }

    }

}