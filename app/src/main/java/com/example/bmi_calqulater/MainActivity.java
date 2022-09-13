package com.example.bmi_calqulater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText weight, height;
    TextView resultText;
    String calculation,result;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight =  findViewById(R.id.weight);
        height = findViewById(R.id.height);
        resultText = findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.btnCalculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBmi();
            }
        });

    }

    public void calculateBmi(){

        String s1 = weight.getText().toString();
        String s2 = height.getText().toString();

        float weightValue = Float.parseFloat(s1);
        float heightValue = Float.parseFloat(s2)/100;

        float bmi = weightValue / (heightValue * heightValue);


        if (bmi<18.5){
            result = "Under Weight";
        }else if(bmi > 18.5 && bmi <23){
            result = "Normal Weight";
        }else if(bmi >= 23 && bmi <27.5){
            result = "Pre - Obese";
        }else if(bmi >= 27.5){
            result = "Obese";
        }

        calculation = "Result :" + bmi+"\n\n"+result;

        resultText.setText(calculation);

    }}