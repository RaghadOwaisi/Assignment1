package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    private ListView listView;
    private QuestionAdapter adapter;
    private Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        listView = findViewById(R.id.listViewQuestions);
        checkButton = findViewById(R.id.buttonCheck);

        ArrayList<Questions> questions = new ArrayList<>();
        questions.add(new Questions("3 + 1", new String[]{"6", "5", "4"}, 2));
        questions.add(new Questions("2 + 4", new String[]{"6", "5", "8"}, 0));
        questions.add(new Questions("6 + 3", new String[]{"8", "9", "10"}, 1));
        questions.add(new Questions("Complete: Bana_a", new String[]{"n", "b", "m"}, 0));
        questions.add(new Questions("Complete: _pple", new String[]{"A", "B", "C"}, 0));
        questions.add(new Questions("Complete: _range", new String[]{"h", "O", "k"}, 1));

        adapter = new QuestionAdapter(this, questions);
        listView.setAdapter(adapter);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int correctAnswers = checkAnswers();
                Toast.makeText(QuizActivity.this, "You got " + correctAnswers + " correct answers out of " + questions.size(), Toast.LENGTH_LONG).show();
            }
        });
        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizActivity.this, CoursesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private int checkAnswers() {
        int correctCount = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View view = listView.getChildAt(i);
            if (view != null) {
                Questions question = (Questions) adapter.getItem(i);
                RadioGroup group = view.findViewById(R.id.radioGroupChoices);
                if (group.getCheckedRadioButtonId() == question.getAnswerIndex()) {
                    correctCount++;
                }
            }
        }
        return correctCount;
    }
}
