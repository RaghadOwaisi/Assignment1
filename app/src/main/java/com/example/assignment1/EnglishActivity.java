package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class EnglishActivity extends AppCompatActivity {

    private static final String TAG = "EnglishActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);

        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnglishActivity.this, CoursesActivity.class);
                startActivity(intent);
                finish();
            }
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Activity is being destroyed.");
    }
}
