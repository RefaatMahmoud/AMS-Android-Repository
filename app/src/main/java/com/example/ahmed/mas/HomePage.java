package com.example.ahmed.mas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
    }
    public void next(View view){
        Intent intent = new Intent(this,LoginForm.class);
        startActivity(intent);
    }
}
