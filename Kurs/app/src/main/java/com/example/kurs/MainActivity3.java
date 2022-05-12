package com.example.kurs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

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
    private DatabaseReference mDataBase;
    private String RASHOD_KEY = "Rashod";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        getDataFromDB1();


    }
    private void init()
    {
        listView = findViewById(R.id.ListViewRashod);
        listData = new ArrayList<>();
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
                for(DataSnapshot ds : snapshot.getChildren())
                {
                    Doxod doxod = ds.getValue(Doxod.class);
                    assert doxod != null;
                    listData.add(doxod.summ);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDataBase.addValueEventListener(vlistener);
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