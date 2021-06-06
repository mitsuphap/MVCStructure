package com.example.mvcstructure.activity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvcstructure.R;
import com.example.mvcstructure.util.ScreenUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenWidth = ScreenUtils.getInstance().getScreenWidth();
        int screenHeight = ScreenUtils.getInstance().getScreenHeight();

        Toast.makeText(this, "Width = " + screenWidth + " Height = " + screenHeight,
                Toast.LENGTH_SHORT);

        if (Build.VERSION.SDK_INT >= 21) {
            //Run on Android 21+
        } else {
            //Run on Android 1-20
        }
    }
}