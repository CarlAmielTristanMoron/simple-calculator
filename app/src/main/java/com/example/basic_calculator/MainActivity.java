package com.example.basic_calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the value in textview
        display = findViewById(R.id.textView);

        //remove default keyboard
        display.setShowSoftInputOnFocus(false);

        //clear when click
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.text).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    //update display base on clicked button
    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.text).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else{
            display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
            display.setSelection(cursorPos + 1);
        }

    }

    public void zero(View view){
        updateText("0");
    }
    public void one(View view){
        updateText("1");
    }
    public void two(View view){
        updateText("2");
    }
    public void three(View view){
        updateText("3");
    }
    public void four(View view){
        updateText("4");
    }
    public void five(View view){
        updateText("5");
    }
    public void six(View view){
        updateText("6");
    }
    public void seven(View view){
        updateText("7");
    }
    public void eight(View view){
        updateText("8");
    }
    public void nine(View view){
        updateText("9");
    }
    public void plus(View view){
        updateText("+");
    }
    public void minus(View view){
        updateText("-");
    }
    public void times(View view){
        updateText("*");
    }
    public void divide(View view){
        updateText("/");
    }
    public void clear(View view){
        display.setText("");
    }
    public void equal(View view){
        String userExp = display.getText().toString();

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }
    public void backspace(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }
}