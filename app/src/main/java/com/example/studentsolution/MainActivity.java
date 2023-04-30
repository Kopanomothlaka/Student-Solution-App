package com.example.studentsolution;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    private CardView passOutBtn, StudentCardBtn , MyStuffBtn,StolenGoodsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passOutBtn = findViewById(R.id.openpassactivityId);
        StudentCardBtn = findViewById(R.id.openstudentcardId);
        MyStuffBtn = findViewById(R.id.openmystuffId);
        StolenGoodsBtn = findViewById(R.id.openstolengoodsId);

        passOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this , PassOutActivity.class);
                startActivity(intent1);
            }
        });
        StudentCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this , StudentCardActivity.class);
                startActivity(intent2);
            }
        });
        MyStuffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this , MyStuffActivity.class);
                startActivity(intent3);
            }
        });
        StolenGoodsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity.this , StolenGoodsActivity.class);
                startActivity(intent4);
            }
        });
    }
}