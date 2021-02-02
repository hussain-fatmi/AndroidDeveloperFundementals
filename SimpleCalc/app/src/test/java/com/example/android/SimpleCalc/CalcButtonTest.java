package com.example.android.SimpleCalc;

import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class CalcButtonTest {

    @Mock
    private Button calcButton;

    @Before
    public void setUpButton(){
        calcButton.performClick();
    }

    @Test
    public void calc(){

    }
}
