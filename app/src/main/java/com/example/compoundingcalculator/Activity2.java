package com.example.compoundingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        EditText e1 = findViewById(R.id.amount);
        EditText e2 = findViewById(R.id.time);
        EditText e3 = findViewById(R.id.cagr);
        TextView t1 = findViewById(R.id.result);
        Button b1 = findViewById(R.id.button);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(e1.getText()) || TextUtils.isEmpty(e2.getText()) || TextUtils.isEmpty(e3.getText()) ||
                        !TextUtils.isDigitsOnly(e1.getText()) || !TextUtils.isDigitsOnly(e2.getText()) || !TextUtils.isDigitsOnly(e3.getText())) {

                    Toast t = Toast.makeText(Activity2.this, "Invalid Input!!", Toast.LENGTH_SHORT);
                    t.show();

                } else {
                    double amount = Double.parseDouble(e1.getText().toString());
                    int time = Integer.parseInt(e2.getText().toString());
                    double cagr = Double.parseDouble(e3.getText().toString());

                    for (int i = 1; i <= time; i++) {
                        amount = amount + (amount * cagr / 100);
                    }
                    int b = (int) amount;

                    t1.setText("$" + b);

                }

            }
        });
    }
}