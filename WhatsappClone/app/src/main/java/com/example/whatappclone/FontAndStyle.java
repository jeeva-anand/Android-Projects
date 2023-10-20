package com.example.whatappclone;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sampleviews.R;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FontAndStyle extends AppCompatActivity {

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font_and_style);
        Button btn = findViewById(R.id.btn);

        if (btn != null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textColorChange();
                    textFontFamily();

                }
            });
        }
    }
    public void textColorChange(){
        String characters = "0123456789ABCDEF";
        StringBuilder codeBuilder = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            codeBuilder.append(randomChar);
        }

        TextView txt1 = findViewById(R.id.txt_msg);
        TextView txt2 = findViewById(R.id.txt_pri);

        String s = codeBuilder.toString();
        txt1.setTextColor(Color.parseColor("#" + s));
        txt2.setTextColor(Color.parseColor("#" + s));
    }

    public void textFontFamily(){
        List<String> fontStyle = Arrays.asList("robotoregular","robotothinitalic","robotothin","robotomediumitalic","robotomedium","robotolightitalic","robotobolditalic","robotobold","robotoblackitalic","robotoblack");

        TextView txt1 = findViewById(R.id.txt_msg);
        TextView txt2 = findViewById(R.id.txt_pri);

        int ranFont = random.nextInt(fontStyle.size()-1);
        Typeface type = Typeface.createFromAsset(getAssets(), "font/" +fontStyle.get(ranFont)+".ttf");
        txt1.setTypeface(type);
        txt2.setTypeface(type);
    }
}