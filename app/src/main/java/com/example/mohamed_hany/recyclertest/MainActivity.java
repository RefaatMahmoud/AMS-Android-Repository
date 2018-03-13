package com.example.mohamed_hany.recyclertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<model> modelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private adapter mAdapter;
    private LinearLayout linearDialog;
    public Button button_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);


        mAdapter = new adapter(modelList , MainActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        prepareData();



    }
    private void prepareData() {
        model model = new model("Computer Vision" , R.drawable.instructor ,"10:30 Am" ,"Section" );
        modelList.add(model);

         model = new model("Natural Language Processing", R.drawable.instructor2,"12:00 pm" ,"Section");
        modelList.add(model);

        model = new model( "Distributed System", R.drawable.ic_camera_alt_black_24dp ,"2:30 pm" ,"Lecture");
        modelList.add(model);

        model = new model( "Network", R.drawable.instructor2 ,"4:30 pm" ,"Section");
        modelList.add(model);

        model = new model( "Artificial Inteligence", R.drawable.instructor2 ,"5:30 pm" ,"Lecture");
        modelList.add(model);





        mAdapter.notifyDataSetChanged();
    }

}
