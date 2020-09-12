package com.example.helloconstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);

    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this,R.string.toast_message,Toast.LENGTH_LONG);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        findViewById(R.id.button_zero).setBackgroundColor(Color.parseColor("#FF69B4"));
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        if (mCount%2 == 0)
            view.setBackgroundColor(Color.parseColor("#32CD32"));
        else
            view.setBackgroundColor(Color.parseColor("#6200EE"));
    }

    public void zeroCount(View view) {
        mCount=0;
        mShowCount.setText(Integer.toString(mCount));
        view.setBackgroundColor(Color.parseColor("#808080"));
        findViewById(R.id.button_count).setBackgroundColor(Color.parseColor("#6200EE"));
    }
}