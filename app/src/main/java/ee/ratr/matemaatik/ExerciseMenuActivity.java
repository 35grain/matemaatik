package ee.ratr.matemaatik;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;

public class ExerciseMenuActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_TEXT = "ee.ratr.matemaatik.EXTRA_TEXT";
    GridLayout exerciseGrid;
    public String exerciseType;

    @SuppressLint("SetTextI18n")
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

        // exercise menu grid layout
        getGridButton();
    }


    private void getGridButton() {
        exerciseGrid = (GridLayout) findViewById(R.id.exerciseGrid);
        Button buttonAdd = exerciseGrid.findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);
        Button buttonSubtract = exerciseGrid.findViewById(R.id.buttonSubtract);
        buttonSubtract.setOnClickListener(this);
        Button buttonMultiply = exerciseGrid.findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(this);
        Button buttonDivide = exerciseGrid.findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(this);
        Button buttonExponentiate = exerciseGrid.findViewById(R.id.buttonExponentiate);
        buttonExponentiate.setOnClickListener(this);
        Button buttonRandom = exerciseGrid.findViewById(R.id.buttonRandom);
        buttonRandom.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAdd:
                exerciseType = "a";
                Log.d("chose", "add");
                break;
            case R.id.buttonSubtract:
                exerciseType = "s";
                Log.d("chose", "subtract");
                break;
            case R.id.buttonMultiply:
                exerciseType = "m";
                break;
            case R.id.buttonDivide:
                exerciseType = "d";
                break;
            case R.id.buttonExponentiate:
                exerciseType = "e";
                break;
            case R.id.buttonRandom:
                exerciseType = "r";
                break;
            default:
                break;
        }
        toExerciseSettings();
    }

    public void onBackPressed() { backToLastPage(); }

    private void backToLastPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void toExerciseSettings() {
        Intent intent = new Intent(this, ExerciseSettingsActivity.class);
        intent.putExtra(EXTRA_TEXT, exerciseType);
        startActivity(intent);
    }

    public String getExerciseType() {
        return exerciseType;
    }
}