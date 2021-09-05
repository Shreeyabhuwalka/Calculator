package com.example.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display=findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText().toString()))
                {
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String strToadd)
    {
        String oldStr=display.getText().toString();
        int cursorPos= display.getSelectionStart();
        String leftStr=oldStr.substring(0,cursorPos);
        String rightStr=oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString()))
        {
            display.setText(strToadd);
            display.setSelection(cursorPos + 1);
        }
        else {
            display.setText(String.format("%s%s%s", leftStr, strToadd, rightStr));
            display.setSelection(cursorPos + 1);
        }
    }

    public void zeroButton(View view){
        updateText("0");
    }
    public void oneButton(View view){
        updateText("1");
    }
    public void twoButton(View view){
        updateText("2");
    }
    public void threeButton(View view){
        updateText("3");
    }
    public void fourButton(View view){
        updateText("4");
    }
    public void fiveButton(View view){
        updateText("5");
    }
    public void sixButton(View view){
        updateText("6");
    }
    public void sevenButton(View view){
        updateText("7");
    }
    public void eightButton(View view){
        updateText("8");
    }
    public void nineButton(View view){
        updateText("9");
    }
    public void addButton(View view){
        updateText("+");
    }
    public void subButton(View view){
        updateText("-");
    }
    public void divButton(View view){
        updateText("/");
    }
    public void mulButton(View view){
        updateText("*");
    }
    public void deciButton(View view){
        updateText(".");
    }
    public void clrButton(View view){
        display.setText("");
    }
    public void equalButton(View view){
        String expression = display.getText().toString();

        Expression exp = new Expression(expression);
        String res = String.valueOf(exp.calculate());
        display.setText(res);
        display.setSelection(res.length());
    }
}