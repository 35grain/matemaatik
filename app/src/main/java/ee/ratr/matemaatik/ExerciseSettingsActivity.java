package ee.ratr.matemaatik;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class ExerciseSettingsActivity extends AppCompatActivity {
    SeekBar seekBar1;
    SeekBar seekBar2;
    TextView exAmount;
    TextView difficulty;
    int finalExAmount;
    int difficultLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_settings);

        // removes status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // button to main activity
        ImageButton backButton = (ImageButton) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToLastPage();
            }
        });

        // button to Exercise
        Button buttonToExerciseMenu = findViewById(R.id.buttonToExercise);
        buttonToExerciseMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toExercise();
            }
        });

        // progress bar of exercise amount
        exAmount = findViewById(R.id.ylesandeArv);
        seekBar1 = findViewById(R.id.seekBar);
        seekBar1.incrementProgressBy(5);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = progress / 5;
                progress = progress * 5;
                exAmount.setText("Ülesannete arv: " + String.valueOf(progress + 5));
                finalExAmount = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        // progress bar of exercise difficulty
        difficulty = findViewById(R.id.difficulty);
        seekBar2 = findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0)
                    difficulty.setText("Lihtne");
                else if (progress == 1)
                    difficulty.setText("Tavaline");
                else if (progress == 2)
                    difficulty.setText("Raske");
                difficultLevel = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void backToLastPage() {
        Intent intent = new Intent(this, ExerciseMenuActivity.class);
        startActivity(intent);
    }

    private void toExercise() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("exercise", getIntent().getStringExtra(ExerciseMenuActivity.EXTRA_TEXT));
        intent.putExtra("MAX_VALUE", finalExAmount + 5);
        intent.putExtra("DIFFICULTY", difficultLevel);
        startActivity(intent);
    }
}