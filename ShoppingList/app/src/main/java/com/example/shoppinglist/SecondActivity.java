package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM = "com.example.android.twoactivities.extra.ITEM";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void itemAdd(View view){
        // Finds the name of the item clicked by the user to be saved in an extra
        Button b = (Button)view;
        Log.d("LOG", b.getText().toString());
        Intent replyIntent = new Intent();
        String reply = b.getText().toString();
        replyIntent.putExtra(EXTRA_ITEM, reply);
        // extra sent to in a result
        setResult(RESULT_OK,replyIntent);
        finish();
    }

}