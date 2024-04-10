package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("myPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        TextView tv = (TextView) findViewById(R.id.tv);
        ConstraintLayout parent = findViewById(R.id.parent);

        int TextSize = sharedPreferences.getInt("text_size",-1);
        int backgroundColor = sharedPreferences.getInt("background_color", -1);

        if (TextSize != -1 && backgroundColor != -1){
            tv.setTextSize(TextSize);
            parent.setBackgroundColor(backgroundColor);
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent.setBackgroundColor(Color.YELLOW);
                tv.setTextSize(15);
                editor.putInt("background_color", Color.YELLOW);
                editor.putInt("text_size", 15);
                editor.apply();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent.setBackgroundColor(Color.BLUE);
                tv.setTextSize(50);
                editor.putInt("background_color", Color.BLUE);
                editor.putInt("text_size", 50);
                editor.apply();
            }
        });


    }
}