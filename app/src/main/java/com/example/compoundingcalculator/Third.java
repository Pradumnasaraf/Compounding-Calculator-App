package com.example.compoundingcalculator;


import androidx.appcompat.app.AppCompatActivity;

import android.icu.number.NumberFormatter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Third extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        EditText e1 = findViewById(R.id.amount);
        EditText e2 = findViewById(R.id.time);
        EditText e3 = findViewById(R.id.cagr);
        TextView t1 = findViewById(R.id.result);
        Button b1 = findViewById(R.id.button);
        TextView t2 = findViewById(R.id.name);
        t2.setText("Hey! " + getIntent().getStringExtra("name"));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(e1.getText()) || TextUtils.isEmpty(e2.getText()) || TextUtils.isEmpty(e3.getText())) {

                    Toast t = Toast.makeText(Third.this, "Invalid Input!!", Toast.LENGTH_SHORT);
                    t.show();

                } else {
                    double amount = Double.parseDouble(e1.getText().toString());
                    int time = Integer.parseInt(e2.getText().toString());
                    double cagr = Double.parseDouble(e3.getText().toString());

                    for (int i = 1; i <= time; i++) {
                        amount = amount + (amount * cagr / 100);
                    }

                    // Decimal formatter will only return decimal number number 1 place eg: 0.1
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    String formattedDecimal = decimalFormat.format(amount);

                    t1.setText("$" + formattedDecimal);

                }

            }
        });
    }
}