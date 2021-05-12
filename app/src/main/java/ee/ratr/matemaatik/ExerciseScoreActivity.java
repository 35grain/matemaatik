package ee.ratr.matemaatik;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import ee.ratr.matemaatik.R;

public class ExerciseScoreActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_score);

        // removes status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // removes status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        // displaying user score
        int score = ExerciseActivity.getInstance().getScore();
        TextView textViewChange = findViewById(R.id.userScoreDisplay);
        textViewChange.setText(String.valueOf(score));


        // displaying user high score
        TextView highScoreLabel = findViewById(R.id.highScore);
        SharedPreferences sp = getSharedPreferences("HIGH_SCORE", Context.MODE_PRIVATE);
        int highScore = sp.getInt("HIGH_SCORE", -10000);

        boolean saveScore = false;
        if (score > highScore) {
            highScoreLabel.setText(getResources().getString(R.string.new_highscore));
            saveScore = true;
        } else {
            highScoreLabel.setText(getResources().getString(R.string.highscore) + " " + highScore);
        }

        // back to menu and saving score
        boolean finalSaveScore = saveScore;
        Button buttonToExerciseMenu = (Button) findViewById(R.id.buttonExerciseMenu);
        buttonToExerciseMenu.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                scoreSaving(finalSaveScore, sp, score);
                openExerciseMenu();
            }
        });

        // redo exercise and saving score
        Button buttonAgain = (Button) findViewById(R.id.buttonAgain);
        buttonAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreSaving(finalSaveScore, sp, score);
                redoExercise();
            }
        });
    }

    public void openExerciseMenu() {
        Intent intent = new Intent(this, ExerciseMenuActivity.class);
        startActivity(intent);
        finish();
    }

    public void redoExercise() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        startActivity(intent);
        finish();
    }

    private void scoreSaving(boolean saveScore, SharedPreferences sp, int score) {
        if (saveScore) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("HIGH_SCORE", score);
            editor.commit();
        }
    }
}