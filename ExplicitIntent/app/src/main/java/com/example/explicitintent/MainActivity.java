package com.example.explicitintent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.radGrp);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                radioGroup = (RadioGroup) group.findViewById(R.id.radGrp);
                int id = radioGroup.getId();

//                if (id == R.id.netflix) {
//                    Intent send = new Intent(MainActivity.this, Netflix.class);
//                    startActivity(send);
//
//                } else if (id == R.id.what_s_app) {
//                    Intent send = new Intent(MainActivity.this, Whatsapp.class);
//                    startActivity(send);
//
//                }else if(id == R.id.youtue){
//
//
//                }


            }
        });


    }
}