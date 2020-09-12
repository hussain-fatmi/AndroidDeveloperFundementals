package com.example.threebuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.threebuttons.extra.Message";
    private EditText mMessageEditText;
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(LOG_TAG, Integer.toString(requestCode));
        if(requestCode == TEXT_REQUEST) {
            Log.d(LOG_TAG, "FIRST IF");
            Log.d(LOG_TAG, Integer.toString(resultCode));
            if(resultCode == RESULT_OK) {
                Log.d(LOG_TAG, "SECOND IF");
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                Log.d(LOG_TAG, reply);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }

    }

    public void launchSecondActivityOne(View view){
        Log.d(LOG_TAG, "Button One Clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = "One";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void launchSecondActivityTwo(View view){
        Log.d(LOG_TAG, "Button Two Clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = "Two";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void launchSecondActivityThree(View view){
        Log.d(LOG_TAG, "Button Three Clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = "Three";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }
}