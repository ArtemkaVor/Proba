package com.example.kurs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private List<Doxod> listTemp;
    private DatabaseReference mDataBase;
    private String DOXOD_KEY = "Doxod";
    public double summdoxod = 0;
    private double a;
    private TextView txtsummdoxod;
    public String d;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        getDataFromDB();
        setOnClickItem();
        // tr();




    }
    //Присваивание переменной значения ListView в который будут выводиться значения
    //Присваивание переменным ArrayList(аналог массива)
    //Создаём адаптер нужный для вывода элементов
    private void init()
    {
        listView = findViewById(R.id.ListViewDoxod);
        listData = new ArrayList<>();
        listTemp = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        listView.setAdapter(adapter);
        mDataBase = FirebaseDatabase.getInstance().getReference(DOXOD_KEY);

    }
    //Создаём цикл добавляющий все данные в список и считающий сумму
    //Выводим всё на экран
    public void getDataFromDB()
    {
        ValueEventListener vlistener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                if(listData.size() > 0) listData.clear();
                if(listTemp.size() > 0) listTemp.clear();
                for(DataSnapshot ds : snapshot.getChildren())
                {
                    Doxod doxod = ds.getValue(Doxod.class);
                    assert doxod != null;
                    listData.add(doxod.summ);
                    listTemp.add(doxod);
                    a = Double.parseDouble(doxod.summ);
                    summdoxod = summdoxod + a;
                }
                adapter.notifyDataSetChanged();
                d = Double.toString(summdoxod);
                txtsummdoxod = findViewById(R.id.txtsummdoxod);
                txtsummdoxod.setText(d);


            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDataBase.addValueEventListener(vlistener);
    }

    // Демонстрации информации полученный из цикла в OnDataChange и показ информации на новом активити
    private void setOnClickItem()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Doxod doxod = listTemp.get(position);
                Intent i = new Intent(MainActivity2.this, ShowActivity.class);
                i.putExtra("summ_show",doxod.summ);
                i.putExtra("comm_show",doxod.comm);
                i.putExtra("date_show",doxod.date);
                startActivity(i);

            }
        });
    }
    public void tr(View v)
    {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("doxodtr",d);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        ImageView gotomenu = (ImageView) findViewById(R.id.menugo);
        gotomenu.setOnClickListener(this);
        ImageView gotoadd = (ImageView) findViewById(R.id.addDoxod);
        gotoadd.setOnClickListener(this);
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