package com.example.matemaatik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class ExerciseMenuActivity extends AppCompatActivity {
    GridLayout exerciseGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_menu);

        // removes status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // button back to last activity
        ImageButton backButton = (ImageButton) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToLastPage();
            }
        });

        // Exercise menu grid layout
        exerciseGrid = (GridLayout) findViewById(R.id.exerciseGrid);
        setSingleEvent(exerciseGrid);
    }

    private void setSingleEvent(GridLayout exerciseGrid) {
        for (int i = 0; i < exerciseGrid.getChildCount(); i++) {
            Button button = (Button) exerciseGrid.getChildAt(i);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toExercise();
                }
            });
        }
    }

    private void backToLastPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void toExercise() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        startActivity(intent);
    }
}