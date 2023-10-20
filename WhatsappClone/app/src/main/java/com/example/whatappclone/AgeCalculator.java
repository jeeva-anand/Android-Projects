package com.example.whatappclone;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sampleviews.R;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator extends AppCompatActivity {

    Button ageCal;
    EditText ipValue;

    TextView txt_view;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);

        ageCal = findViewById(R.id.btn_cal);
        ipValue = findViewById(R.id.ip_age_value);
        txt_view = findViewById(R.id.op_txt);

        String age =ipValue.getText().toString();

        LocalDate dob = LocalDate.parse(age);
        LocalDate currentDate = LocalDate.now();

        Period res = Period.between(dob,currentDate);
        txt_view.setText(res.toString());



    }
}