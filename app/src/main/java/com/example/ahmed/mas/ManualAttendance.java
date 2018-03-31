package com.example.ahmed.mas;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class ManualAttendance extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> data;
    private StudentRowAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manual_attendance);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        data = new ArrayList<>();
        adapter = new StudentRowAdapter(getApplicationContext(),data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        for(int i = 0 ; i<25;i++){
//            data.add("Student "+ i);
//        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }
}
