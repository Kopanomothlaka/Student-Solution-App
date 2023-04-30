package com.example.studentsolution;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class reset_password extends AppCompatActivity {
    private EditText emailRestEditText, passResetEditText, confirmPassEditText;
    private Button resetPassBtn;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        emailRestEditText = findViewById(R.id.restEmailId);
        passResetEditText = findViewById(R.id.resetPassId);
        confirmPassEditText = findViewById(R.id.resetconfirmPassid);
        resetPassBtn = (Button) findViewById(R.id.restpassBtn);
        auth = FirebaseAuth.getInstance();
        resetPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetUserPassword();
            }
        });
    }

    private void resetUserPassword() {

        String email = emailRestEditText.getText().toString();
        String password = passResetEditText.getText().toString();
        String confirmpassword = confirmPassEditText.getText().toString();


        if (email.isEmpty()) {
            emailRestEditText.requestFocus();
            emailRestEditText.setError("PLase ewnter yout email");
            return;
        } else if (password.isEmpty() || password.length() < 6) {
            passResetEditText.requestFocus();
            passResetEditText.setError("New password required");
            return;
        } else if (confirmpassword.isEmpty()) {
            confirmPassEditText.requestFocus();
            confirmPassEditText.setError("Confirm your password");
            return;
        } else if (!password.equals(confirmpassword)) {
            confirmPassEditText.requestFocus();
            confirmPassEditText.setError("Password dont match");
            return;

        } else {

            // Update user's password
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                user.updatePassword(password)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    // Password updated successfully
                                                    Toast.makeText(reset_password.this, "Password updated successfully", Toast.LENGTH_LONG).show();
                                                } else {
                                                    // Password update failed
                                                    Toast.makeText(reset_password.this, "Failed to update password", Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });
                            } else {
                                // Authentication failed
                                Toast.makeText(reset_password.this, "Authentication failed", Toast.LENGTH_LONG).show();
                            }

                        }
                    });


        }

    }
}