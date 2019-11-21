package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private     boolean isOpPressed= false;

    private double firstNuber=0;
    private int secondNumberIndex=0;
    private boolean lastNum=false;
    private char currentOp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);
        final TextView calculatorScreen= findViewById(R.id.calculatorScreen);
        final Button n0 = findViewById(R.id.n0);
        final Button n1 = findViewById(R.id.n1);
        final Button n2 = findViewById(R.id.n2);
        final Button n3 = findViewById(R.id.n3);
        final Button n4 = findViewById(R.id.n4);
        final Button n5 = findViewById(R.id.n5);
        final Button n6 = findViewById(R.id.n6);
        final Button n7 = findViewById(R.id.n7);
        final Button n8 = findViewById(R.id.n8);
        final Button n9 = findViewById(R.id.n9);
        final Button dot = findViewById(R.id.dot);
        final Button equals = findViewById(R.id.equals);
        final Button addition = findViewById(R.id.addition);
        final Button subtraction = findViewById(R.id.subtraction);
        final Button multiplication = findViewById(R.id.multiplication);
        final Button division = findViewById(R.id.division);

        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id= v.getId();
                switch (id){
                    case R.id.n0:
                        calculatorScreen.append("0");
                        lastNum=true;
                        break;
                    case R.id.n1:
                        calculatorScreen.append("1");
                        lastNum=true;
                        break;
                    case R.id.n2:
                        calculatorScreen.append("2");
                        lastNum=true;
                        break;
                    case R.id.n3:
                        calculatorScreen.append("3");
                        lastNum=true;
                        break;
                    case R.id.n4:
                        calculatorScreen.append("4");
                        lastNum=true;
                        break;
                    case R.id.n5:
                        calculatorScreen.append("5");
                        lastNum=true;
                        break;
                    case R.id.n6:
                        calculatorScreen.append("6");
                        lastNum=true;
                        break;
                    case R.id.n7:
                        calculatorScreen.append("7");
                        lastNum=true;
                        break;
                    case R.id.n8:
                        calculatorScreen.append("8");
                        lastNum=true;
                        break;
                    case R.id.n9:
                        calculatorScreen.append("9");
                        lastNum=true;
                        break;
                    case R.id.equals:
                        Log.d("CALC", "estem a ===");
                        if(isOpPressed&&lastNum){
                            if(currentOp=='+'){
                                Log.d("CALC1", "estem a +");
                                String screenContent= calculatorScreen.getText().toString();
                                String secondNumberString=screenContent.substring(secondNumberIndex,screenContent.length());
                                double secondNumber=Double.parseDouble(secondNumberString);
                                Log.d("CALC1", "first "+firstNuber+" second:"+secondNumber);
                                secondNumber=secondNumber+firstNuber;
                                Log.d("CALC1", " resultat:"+secondNumber);
                                firstNuber=secondNumber;
                                calculatorScreen.setText(String.valueOf(secondNumber));
                                currentOp=' ';
                                isOpPressed=false;
                            }
                        }
                        //calculatorScreen.append("=");
                        break;
                    case R.id.addition:
                        if(isOpPressed) {

                        }
                        else {
                            String screenContent = calculatorScreen.getText().toString();
                            secondNumberIndex = screenContent.length() + 1;
                            firstNuber = Double.parseDouble(screenContent);//falla porque intenta insertar un character en un double
                            calculatorScreen.append("+");
                            currentOp = '+';
                            isOpPressed = true;
                            lastNum = false;
                        }
                        break;
                    case R.id.division:
                       // calculatorScreen.append("/");
                        break;
                    case R.id.dot:
                        calculatorScreen.append(".");
                        break;

                    case R.id.multiplication:
                        //calculatorScreen.append("X");
                        break;
                    case R.id.subtraction:
                        //calculatorScreen.append("-");
                        break;
                }
            }
        };
        n0.setOnClickListener(calculatorListener);
        n1.setOnClickListener(calculatorListener);
        n2.setOnClickListener(calculatorListener);
        n3.setOnClickListener(calculatorListener);
        n4.setOnClickListener(calculatorListener);
        n5.setOnClickListener(calculatorListener);
        n6.setOnClickListener(calculatorListener);
        n7.setOnClickListener(calculatorListener);
        n8.setOnClickListener(calculatorListener);
        n9.setOnClickListener(calculatorListener);
        addition.setOnClickListener(calculatorListener);
        multiplication.setOnClickListener(calculatorListener);
        division.setOnClickListener(calculatorListener);
        dot.setOnClickListener(calculatorListener);
        subtraction.setOnClickListener(calculatorListener);
        equals.setOnClickListener(calculatorListener);

        final Button delete = findViewById(R.id.del);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayElements =calculatorScreen.getText().toString();
                int length =displayElements.length();
                if (length>0){
                    displayElements=displayElements.substring(0,length-1);
                    calculatorScreen.setText(displayElements);
                }
            }
        });
        final Button clear =findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorScreen.setText("");
            }
        });
    }
}
