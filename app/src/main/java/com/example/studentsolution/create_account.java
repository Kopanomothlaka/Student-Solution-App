package com.example.studentsolution;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class create_account extends AppCompatActivity {
    private EditText etName, etSurname , etInstitution , etStudentNumber , etEmail ,etPassword ,etConfirmPAssword;
    private Button createAccountbtn;
    private TextView loginText;
    private ProgressDialog progressDialog;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        // initialising all the views
        etName = findViewById(R.id.nameId);
        etSurname = findViewById(R.id.surnameId);
        etInstitution = findViewById(R.id.institutionId);
        etStudentNumber = findViewById(R.id.studentId);
        etEmail = findViewById(R.id.emailId);
        etPassword= findViewById(R.id.passwordId);
        etConfirmPAssword= findViewById(R.id.confirmpasswordId);
        createAccountbtn =(Button) findViewById(R.id.accountBtnId);
        loginText = findViewById(R.id.loginTextviewId);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();




        //set on Click LListener for registration btn and log in Textview
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(create_account.this , login.class);
                startActivity(intent);
            }
        });

        //set on click listener for user registration
        createAccountbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerNewUser();
            }
        });

    }

    private void registerNewUser() {
        //take the editText values to string
        String name = etName.getText().toString();
        String surname= etSurname.getText().toString();
        String varsity = etInstitution.getText().toString();
        String studentNUmber = etStudentNumber.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String confirmPassword = etConfirmPAssword.getText().toString();

        if (name.length()==0){
            etName.requestFocus();
            etName.setError("Enter your name !");
            return;
        }
        else if (!name.matches("[a-zA-Z]")) {
            etName.requestFocus();
            etName.setError("Enter only alphabetical characters");
            return;
        }
        else if (surname.length()==0) {
            etSurname.requestFocus();
            etSurname.setError("Enter your surname !");
            return;

        }
        else if (!surname.matches("[a-zA-Z]")) {
            etSurname.requestFocus();
            etSurname.setError("Enter only alphabetical characters");
            return;

        }
        else if (varsity.length()==0) {
            etInstitution.requestFocus();
            etInstitution.setError("Enter the name of the institution");
            return;

        }
        else if (!varsity.matches("[a-zA-Z]")) {
            etInstitution.requestFocus();
            etInstitution.setError("Enter only alphabetical characters");
            return;
        }
        else if (studentNUmber.isEmpty()) {

            etStudentNumber.requestFocus();
            etStudentNumber.setError("Enter student NUmber");
            return;

        } else if (email.isEmpty()) {
            etEmail.requestFocus();
            etEmail.setError("Enter Email");
            return;
        } else if (password.isEmpty() ) {
            etPassword.requestFocus();
            etPassword.setError("Field cannot be empty");
            return;

        } else if (password.length()<6) {
            etPassword.requestFocus();
            etPassword.setError("Your password must have more 6 characters");
            return;

        } else if (!confirmPassword.equals(password)) {
            etConfirmPAssword.requestFocus();
            etConfirmPAssword.setError("Passwords don't match");

        }
        else {
            //the firebase registration steps
            progressDialog.setMessage("Registration in progress");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        //take to main activity
                        Intent mainActivity = new Intent(create_account.this,MainActivity.class);
                        startActivity(mainActivity);
                    }
                    else {
                        Toast.makeText(create_account.this, "Registration failde please try again ", Toast.LENGTH_SHORT).show();
                    }
                    progressDialog.dismiss();
                }
            });


        }


    }
}