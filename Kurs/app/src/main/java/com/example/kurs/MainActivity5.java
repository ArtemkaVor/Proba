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
    private EditText rashodadd;
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
        rashodadd = findViewById(R.id.rashodadd);
        mDataBase = FirebaseDatabase.getInstance().getReference(RASHOD_KEY);
    }

    public void onClickSave(View View)
    {
        String id = mDataBase.getKey();
        String summr = rashodadd.getText().toString();
        Rashod newrashod = new Rashod(id,summr);
        mDataBase.push().setValue(newrashod);

    }
}