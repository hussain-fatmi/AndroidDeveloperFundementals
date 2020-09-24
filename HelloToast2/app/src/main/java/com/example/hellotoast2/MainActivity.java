package com.example.hellotoast2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    public static final String EXTRA_COUNT = "com.example.hellotoast2.extra.Count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void sayHello(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        String count = mShowCount.getText().toString();
        intent.putExtra(EXTRA_COUNT, count);
        startActivity(intent);
    }

    public void countUp(View view){
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
}