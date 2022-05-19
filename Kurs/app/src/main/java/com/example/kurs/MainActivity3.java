package com.example.kurs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private List<Rashod> listTemp;
    private DatabaseReference mDataBase;
    private String RASHOD_KEY = "Rashod";
    public static double summrashod = 0;
    private double a;
    private TextView txtsummrashod;
    public String r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        getDataFromDB1();
        setOnClickItem();


    }
    private void init()
    {
        listView = findViewById(R.id.ListViewRashod);
        listData = new ArrayList<>();
        listTemp = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        listView.setAdapter(adapter);
        mDataBase = FirebaseDatabase.getInstance().getReference(RASHOD_KEY);
    }
    private void getDataFromDB1()
    {
        ValueEventListener vlistener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                if(listData.size() > 0) listData.clear();
                if(listTemp.size() > 0) listTemp.clear();
                for(DataSnapshot ds : snapshot.getChildren())
                {
                    Rashod rashod = ds.getValue(Rashod.class);
                    assert rashod != null;
                    listData.add(rashod.summ);
                    listTemp.add(rashod);
                    a = Double.parseDouble(rashod.summ);
                    summrashod = summrashod + a;
                }
                adapter.notifyDataSetChanged();
                String r = Double.toString(summrashod);
                txtsummrashod = findViewById(R.id.txtsummrashod);
                txtsummrashod.setText(r);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDataBase.addValueEventListener(vlistener);
    }
    private void setOnClickItem()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Rashod rashod = listTemp.get(position);
                Intent i = new Intent(MainActivity3.this, ShowActivityRashod.class);
                i.putExtra("summr_show",rashod.summ);
                i.putExtra("commr_show",rashod.comm);
                i.putExtra("dater_show",rashod.date);
                startActivity(i);

            }
        });
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