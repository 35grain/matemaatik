package com.example.matemaatik;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.matemaatik.equations.Add;
import com.example.matemaatik.equations.Equation;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity {
    private TextView textInputAnswer;
    private int score;
    private static ExerciseActivity instance;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        instance = this;

        // removes status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // list of 5 random adding exercises
        ArrayList<Equation> equations = new ArrayList<Equation>();
        for (int i = 0; i < 10; i++) {
            equations.add(new Add(50, 2));
        }

        textInputAnswer = findViewById(R.id.answer);

        // displaying first exercise
        TextView textViewChange = findViewById(R.id.addText);
        textViewChange.setText(equations.get(0).toString());

        TextView userScoreLive = findViewById(R.id.userScoreLive);

        Button answerButton = findViewById(R.id.buttonAnswer);
        answerButton.setOnClickListener(new View.OnClickListener() {
            int i = 0;

            @Override
            public void onClick(View v) {
                boolean rightAnswer = checkAnswer(equations.get(i).getSolution());
                nextExercise(rightAnswer);
            }

            // changing output value
            public void nextExercise(boolean rightAnswer) {
                if (rightAnswer & i < 10) {
                    score+=2;
                    i++;
                    if (i >= 10)
                        toScorePage();
                    else {
                        textInputAnswer.setText("");
                        userScoreLive.setText(String.valueOf(score));
                        textViewChange.setText(equations.get(i).toString());
                    }
                } else {
                    score--;
                }
            }
        });

        // button back to last activity
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToLastPage();
            }
        });
    }

    private void backToLastPage() {
        Intent intent = new Intent(this, ExerciseMenuActivity.class);
        startActivity(intent);
    }

    private void toScorePage() {
        Intent intent = new Intent(this, ExerciseScoreActivity.class);
        startActivity(intent);
    }

    private boolean validateAnswer() {
        String awnserInput = textInputAnswer.getText().toString().trim();

        if (awnserInput.isEmpty()) {
            textInputAnswer.setError("Pole vastust");
            return false;
        } else {
            textInputAnswer.setError(null);
            return true;
        }
    }

    private boolean checkAnswer(int userAnswer) {
        if (!validateAnswer())
            return false;
        int answerInput = Integer.parseInt(textInputAnswer.getText().toString().trim());
        boolean correct = answerInput == userAnswer;
        if (!correct) textInputAnswer.setError("Vale vastus!");
        return correct;
    }

    public static ExerciseActivity getInstance() {
        return instance;
    }

    int getScore() {
        return score;
    }
}