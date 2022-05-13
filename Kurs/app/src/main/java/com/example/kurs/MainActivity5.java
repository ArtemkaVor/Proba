package com.example.kurs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity5 extends AppCompatActivity {
   private EditText prashodadd,pcommentradd;
   private DatabaseReference mDataBase;
   private String RASHOD_KEY = "Rashod";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        init();
    }

    public void init()
    {
        prashodadd = findViewById(R.id.rashodadd);
        pcommentradd = findViewById(R.id.commentradd);
        mDataBase = FirebaseDatabase.getInstance().getReference(RASHOD_KEY);
    }

    public void onClickSave(View View)
    {
        String id = mDataBase.getKey();
        String summ = prashodadd.getText().toString();
        String comm = pcommentradd.getText().toString();
        Rashod newrashod = new Rashod(id,summ,comm);
        if (!TextUtils.isEmpty(summ))
        {
            mDataBase.push().setValue(newrashod);
            Toast.makeText(this, "Вы добавили сумму", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Введите сумму", Toast.LENGTH_SHORT).show();
        }

    }
}