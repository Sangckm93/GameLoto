package com.example.gameloto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        // Math
        1: làm tròn
            float st1 = 1.999f;
            float valueSt1 = Math.round(st1);   // làm tròn 0.5
            double valueSt2 = Math.ceil(Double.parseDouble(st1 +""));   // làm tròn lên
            double valueSt3 = Math.floor(Double.parseDouble(st1 + "")); // Làm tròn xuống
            Log.d("Test", valueSt3 + "");
        2. random
            double value = Math.round(Math.random()*5); // random từ 0 -> 5
            double value = Math.floor(Math.random()*6); // random từ 0->5 với xác xuất các số bằng nhau
            Log.d("Test", value + "");
        3. Random in Java
            Random random = new Random();
            int max = 127;
            int min = 5;
    //        int value = random.nextInt(10); // random 0-> 9
            int value = random.nextInt(max - min + 1)+min; // Random from min->max
            Log.d("Test", value + "");
         */

    }
}