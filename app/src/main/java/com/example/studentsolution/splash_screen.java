package com.example.studentsolution;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class splash_screen extends AppCompatActivity {
    private static final int SPLASH_SCREEN_TIMEOUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }
}