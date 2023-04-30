package com.example.studentsolution;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class splash_screen extends AppCompatActivity {
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                openNewActivity();
                finish();
            }
        }, 5000 );
    }

    private void openNewActivity() {
        Intent intent = new Intent(splash_screen.this ,getstarted.class);
        startActivity(intent);
    }
}