package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class CoursesActivity extends AppCompatActivity {

    String TAG = "CoursesActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(CoursesActivity.this, StudentLoginActivity.class);
            startActivity(intent);
            finish();
        });

        Button mathCourseButton = findViewById(R.id.mathButton);
        mathCourseButton.setOnClickListener(v -> {
            Intent intent = new Intent(CoursesActivity.this, MathActivity.class);
            startActivity(intent);
            finish();
        });

        Button englishCourseButton = findViewById(R.id.englishButton);
        englishCourseButton.setOnClickListener(v -> {
            Intent intent = new Intent(CoursesActivity.this, EnglishActivity.class);
            startActivity(intent);
            finish();
        });
        Button test = findViewById(R.id.test);
        test.setOnClickListener(v -> {
            Intent intent = new Intent(CoursesActivity.this, QuizActivity.class);
            startActivity(intent);
            finish();
        });


        Log.d(TAG, "onCreate: Activity created.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Activity is starting.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Activity has resumed and is visible.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Activity is pausing.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Activity is stopping.");
    }

}
