package com.example.kurs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private DatabaseReference mDataBase;
    private String DOXOD_KEY = "Doxod";
    public double summdoxod = 0;
    private double a;
    private TextView txtsummdoxod;
    public String d;
    private ListView listView1;
    private ArrayAdapter<String> adapter1;
    private List<String> listData1;
    private DatabaseReference mDataBase1;
    private String RASHOD_KEY = "Rashod";
    public static double summrashod = 0;
    private double a1;
    private TextView txtsummrashod;
    public String r1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getDataFromDB();
        init1();
        getDataFromDB1();
        finalK();





    }
    private void init()
    {
        listView = findViewById(R.id.ListViewDoxod);
        listData = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        listView.setAdapter(adapter);
        mDataBase = FirebaseDatabase.getInstance().getReference(DOXOD_KEY);

    }
    private void init1()
    {
        listView1 = findViewById(R.id.ListViewRashod);
        listData1 = new ArrayList<>();
        adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData1);
        listView1.setAdapter(adapter1);
        mDataBase = FirebaseDatabase.getInstance().getReference(RASHOD_KEY);

    }



    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.doxod:
                intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.Rashod:
                intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
        }

    }
    public void getDataFromDB() {
        ValueEventListener vlistener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (listData.size() > 0) listData.clear();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Doxod doxod = ds.getValue(Doxod.class);
                    assert doxod != null;
                     listData.add(doxod.summ);
                    a = Double.parseDouble(doxod.summ);
                    summdoxod = summdoxod + a;
                }
                adapter.notifyDataSetChanged();
                d = Double.toString(summdoxod);
                txtsummdoxod = findViewById(R.id.outputD);
                txtsummdoxod.setText(d);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        };
        mDataBase.addValueEventListener(vlistener);
    }

    public void getDataFromDB1()
    {
        ValueEventListener vlistener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                if(listData1.size() > 0) listData1.clear();
                for(DataSnapshot ds : snapshot.getChildren())
                {
                    Rashod rashod = ds.getValue(Rashod.class);
                    assert rashod != null;
                    listData1.add(rashod.summ);
                    a1 = Double.parseDouble(rashod.summ);
                    summrashod = summrashod + a1;
                }
                adapter1.notifyDataSetChanged();
                r1 = Double.toString(summrashod);
                txtsummrashod = findViewById(R.id.outputR);
                txtsummrashod.setText(r1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDataBase.addValueEventListener(vlistener);
    }
    public void finalK()
    {




    }
}

