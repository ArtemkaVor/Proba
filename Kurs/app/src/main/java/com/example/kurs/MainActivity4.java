package com.example.kurs;

import androidx.appcompat.app.AppCompatActivity;

import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity4 extends AppCompatActivity {
    private EditText pdoxodadd,pcommentadd;
    private DatabaseReference mDataBase;
    private String DOXOD_KEY = "Doxod";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        init();

    }

    public void init()
    {
        pdoxodadd = findViewById(R.id.doxodadd);
        pcommentadd = findViewById(R.id.commentadd);
        mDataBase = FirebaseDatabase.getInstance().getReference(DOXOD_KEY);
    }

    public void onClickSave(View View)
    {
        String id = mDataBase.getKey();
        String summ = pdoxodadd.getText().toString();
        String comm = pcommentadd.getText().toString();
        Doxod newdoxod = new Doxod(id,summ,comm);
        if (!TextUtils.isEmpty(summ))
        {
            mDataBase.push().setValue(newdoxod);
            Toast.makeText(this, "Вы добавили сумму", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Введите сумму", Toast.LENGTH_SHORT).show();
        }

    }
}