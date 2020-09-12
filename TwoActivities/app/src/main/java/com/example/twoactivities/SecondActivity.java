package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Set;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY";
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReply = findViewById(R.id.editText_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
    }

    @Override
    public void onStart(){
        Log.d(LOG_TAG, "-------");
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    public void onRestart(){
        Log.d(LOG_TAG, "-------");
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    public void onResume(){
        Log.d(LOG_TAG, "-------");
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    public void onStop(){
        Log.d(LOG_TAG, "-------");
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    public void onDestroy(){
        Log.d(LOG_TAG, "-------");
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    public void onPause(){
        Log.d(LOG_TAG, "-------");
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    public void returnReply(View view) {
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "Reply clicked");
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK,replyIntent);
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "End SecondActivity");
        finish();
    }
}