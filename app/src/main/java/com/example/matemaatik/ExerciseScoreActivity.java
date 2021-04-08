package com.example.matemaatik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import static com.google.android.material.internal.ContextUtils.getActivity;

public class ExerciseScoreActivity extends AppCompatActivity {
    private int score;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_score);

        score = ExerciseActivity.getInstance().getScore();
        Log.d("skoor", String.valueOf(score));
        TextView textViewChange = findViewById(R.id.userScoreDisplay);
        textViewChange.setText(String.valueOf(score));

        Button buttonToExerciseMenu = (Button) findViewById(R.id.buttonExerciseMenu);
        buttonToExerciseMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExerciseMenu();
            }
        });

        Button buttonAgain = (Button) findViewById(R.id.buttonAgain);
        buttonAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redoExercise();
            }
        });
    }

    public void openExerciseMenu() {
        Intent intent = new Intent(this, ExerciseMenuActivity.class);
        startActivity(intent);
    }

    public void redoExercise() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        startActivity(intent);
    }
}