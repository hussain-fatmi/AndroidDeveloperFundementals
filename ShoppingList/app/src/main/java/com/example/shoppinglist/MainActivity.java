package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static int openSpace = 1;
    public static int ADD = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // If the next open space exceeds the number of spaces, show a warning toast
        if(openSpace == 11){
            Toast toast = Toast.makeText(this,R.string.toast_full,Toast.LENGTH_LONG);
            toast.show();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("On result: requestCode ", "" + requestCode);
        Log.d("On result: resultCode ", "" + resultCode);
        Log.d("On result: intent ", "" + data);
        if (requestCode == ADD) {
            if (resultCode == RESULT_OK) {

                // Gets the item name using extras
                String reply =
                        data.getStringExtra(SecondActivity.EXTRA_ITEM);
                // open is the name of the open textView in string form
                String open = "item_" + openSpace;
                // textView is now set to the open TextView to display the item on the list
                TextView textView = findViewById(getResId(open, R.id.class));
                // adds the selected item to the list
                textView.setText(reply);
                // increments the open space
                openSpace++;
            }
        }
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Add Item Clicked");

        // if there is no more space on the list, clear the list
        if (openSpace > 10){
            // The user has been warned and are now told that the list will clear
            Toast toast = Toast.makeText(this,R.string.toast_message,Toast.LENGTH_LONG);
            toast.show();
            // looping through the TextViews
            for(int i = 1; i < 11; i++) {
                TextView reset = findViewById(getResId("item_"+i, R.id.class));
                reset.setText("");
            }
            // openSpace reset to the first available space
            openSpace = 1;
        } else {
            // if there is space left on the shopping list open second activity
            Intent intent = new Intent(this, SecondActivity.class);
            startActivityForResult(intent, ADD);
        }
    }

    // finds and returns the id of an object given the name in string form
    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}