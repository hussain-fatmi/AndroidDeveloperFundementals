package com.example.hellotoast2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String count = intent.getStringExtra(MainActivity.EXTRA_COUNT);
        TextView textView = findViewById(R.id.count);
        textView.setText(count);
    }
}