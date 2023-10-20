package com.example.whatappclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sampleviews.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button btn_shape = findViewById(R.id.btn_sha);
        Button btn_clone = findViewById(R.id.btn_cln);
        Button btn_style = findViewById(R.id.btn_style);

        if (btn_shape != null) {
            btn_shape.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent send = new Intent(MainActivity.this, Shapes.class);
                    startActivity(send);
                }
            });
        }

        if (btn_style != null) {
            btn_style.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent send = new Intent(MainActivity.this, FontAndStyle.class);
                    startActivity(send);
                }
            });
        }

        if (btn_clone != null) {
            btn_clone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent send = new Intent(MainActivity.this, WhatAppClone.class);
                    startActivity(send);
                }
            });
        }
    }
}