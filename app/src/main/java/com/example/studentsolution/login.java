package com.example.studentsolution;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
     EditText emailEditText , passwordEditextText;
    private Button loginButton;
    TextView forgotPassTextView , createAccTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.loginEmailId);
        passwordEditextText = findViewById(R.id.loginPassId);
        loginButton = (Button) findViewById(R.id.loginBtnID);
        forgotPassTextView = findViewById(R.id.forgotPassTextViewId);
        createAccTextView = findViewById(R.id.createAccTextviewID);

        forgotPassTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, reset_password.class);
                startActivity(intent);
            }
        });
        createAccTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(login.this, create_account.class);
                startActivity(intent2);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

    }

    private void loginUser() {
        String email = emailEditText.getText().toString();
        String password = passwordEditextText.getText().toString();

        if (email.isEmpty()){
            emailEditText.requestFocus();
            emailEditText.setError("THis filed cannot be empty");
            return;
        } else if (password.isEmpty()) {
            passwordEditextText.requestFocus();
            passwordEditextText.setError("This filed cannot be empty");
            return;

        }
        else {
            //FIrebase sign in code here
        }

    }
}