package com.example.assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class StudentLoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private CheckBox rememberMeCheckBox;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        Button backButton = findViewById(R.id.backButton);
        rememberMeCheckBox = findViewById(R.id.rememberMeCheckBox);

        sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        checkPreferences();

        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(StudentLoginActivity.this, "Username or password cannot be empty", Toast.LENGTH_SHORT).show();
            } else {
                if (rememberMeCheckBox.isChecked()) {
                    saveLoginDetails(username, password);
                } else {
                    clearLoginDetails();
                }
                Intent intent = new Intent(StudentLoginActivity.this, CoursesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        backButton.setOnClickListener(v -> finish());
    }

    private void checkPreferences() {
        String username = sharedPreferences.getString("username", null);
        String password = sharedPreferences.getString("password", null);
        if (username != null && password != null) {
            usernameEditText.setText(username);
            passwordEditText.setText(password);
            rememberMeCheckBox.setChecked(true);
        }
    }

    private void saveLoginDetails(String username, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    private void clearLoginDetails() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("username");
        editor.remove("password");
        editor.apply();
    }
}
