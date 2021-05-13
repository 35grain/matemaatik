package ee.ratr.matemaatik;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class ExerciseScoreActivity extends AppCompatActivity {
    String exType;
    int exAmount;
    int exDifficulty;
    String saveHighScore;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_score);

        // removes status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        // displaying user score
        int score = ExerciseActivity.getInstance().getScore();
        TextView textViewChange = findViewById(R.id.userScoreDisplay);
        textViewChange.setText(String.valueOf(score));


        // displaying user high score
        Intent intent = getIntent();
        exType = intent.getStringExtra("EXERCISE_TYPE");
        exAmount = intent.getIntExtra("EXERCISE_AMOUNT", 0);
        exDifficulty = intent.getIntExtra("DIFFICULTY", 0);

        saveHighScore = exerciseDifficulty(exDifficulty, amountOfExercise(exAmount, typeOfExercise(exType)));

        TextView highScoreLabel = findViewById(R.id.highScore);
        SharedPreferences sp = getSharedPreferences(saveHighScore, Context.MODE_PRIVATE);
        int highScore = sp.getInt(saveHighScore, -10000);

        boolean saveScore = false;
        if (score > highScore) {
            highScoreLabel.setText("Uus parim tulemus!");
            saveScore = true;
        } else {
            highScoreLabel.setText("Parim tulemus : " + highScore);
        }

        // back to menu and saving score
        boolean finalSaveScore = saveScore;
        Button buttonToExerciseMenu = (Button) findViewById(R.id.buttonToExercise);
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
        intent.putExtra("exercise", exType);
        intent.putExtra("MAX_VALUE", exAmount);
        intent.putExtra("DIFFICULTY", exDifficulty);
        startActivity(intent);
        finish();
    }

    private void scoreSaving(boolean saveScore, SharedPreferences sp, int score) {
        if (saveScore) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt(saveHighScore, score);
            editor.commit();
        }
    }

    private String typeOfExercise(String userClickedInMenu) {
        switch (userClickedInMenu) {
            case "a":
                return "HIGH_SCOREa";
            case "s":
                return "HIGH_SCOREs";
            case "m":
                return "HIGH_SCOREm";
            case "d":
                return "HIGH_SCOREd";
            case "e":
                return "HIGH_SCOREe";
            case "r":
                return "HIGH_SCOREr";
            default:
                return null;
        }
    }

    private String amountOfExercise(int amount, String highScore) {
        switch (amount) {
            case 5:
                return highScore + 5;
            case 10:
                return highScore + 10;
            case 15:
                return highScore + 15;
            case 20:
                return highScore + 20;
            case 25:
                return highScore + 25;
            case 30:
                return highScore + 30;
            case 35:
                return highScore + 35;
            case 40:
                return highScore + 40;
            case 45:
                return highScore + 45;
            default:
                return null;
        }
    }

    private String exerciseDifficulty(int exDifficulty, String highScore) {
        switch (exDifficulty) {
            case 0:
                return highScore + 0;
            case 1:
                return highScore + 1;
            case 2:
                return highScore + 2;
            default:
                return null;
        }
    }
}