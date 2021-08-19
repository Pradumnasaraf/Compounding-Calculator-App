package com.example.compoundingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        EditText editText = findViewById(R.id.edittext);

        ImageView b = findViewById(R.id.forwardButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editText.getText())) {
                    Toast.makeText(Second.this, "Enter Your Name", Toast.LENGTH_SHORT).show();
                } else {
                    String s = editText.getText().toString();
                    Intent i = new Intent(Second.this, Third.class);
                    i.putExtra("name", s);
                    startActivity(i);
                }

            }
        });


    }
}