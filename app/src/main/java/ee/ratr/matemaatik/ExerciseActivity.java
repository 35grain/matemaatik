package ee.ratr.matemaatik;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import ee.ratr.matemaatik.R;

import ee.ratr.matemaatik.equations.Add;
import ee.ratr.matemaatik.equations.Equation;

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
                nextExercise();
            }

            // changing output value
            public void nextExercise() {
                int solution = equations.get(i).getSolution();
                if (validateAnswer()) {
                    i++;
                    if (checkAnswer(solution)) {
                        score+=2;
                        if (i >= 10)
                            toScorePage();
                        else {
                            textInputAnswer.setText("");
                            userScoreLive.setText(String.valueOf(score));
                            textViewChange.setText(equations.get(i).toString());
                        }
                    } else {
                        // Show correct solution and temporarily disable buttons
                        score--;
                        answerButton.setEnabled(false);
                        textInputAnswer.setTextColor(Color.RED);
                        textInputAnswer.setError("Õige vastus oli: " + solution);
                        // Wait 2 seconds and display next equation
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                answerButton.setEnabled(true);
                                textInputAnswer.setTextColor(Color.WHITE);
                                textInputAnswer.setText("");
                                textInputAnswer.setError(null);
                                userScoreLive.setText(String.valueOf(score));
                                textViewChange.setText(equations.get(i).toString());
                            }
                        }, 2000);
                    }
                }
            }
        });

        // button back to last activity
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void backToLastPage() {
        Intent intent = new Intent(this, ExerciseMenuActivity.class);
        startActivity(intent);
    }

    public void onBackPressed() {
        // Warn before returning to exercise menu
        AlertDialog.Builder alertdialog=new AlertDialog.Builder(this);
        alertdialog.setTitle("Hoiatus");
        alertdialog.setMessage("Väljudes kaotad punktid. Kindel, et soovid väljuda?");
        alertdialog.setPositiveButton("Jah", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                backToLastPage();
            }
        });

        alertdialog.setNegativeButton("Ei", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }

        });

        AlertDialog alert=alertdialog.create();
        alertdialog.show();

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
        int answerInput = Integer.parseInt(textInputAnswer.getText().toString().trim());
        return answerInput == userAnswer;
    }

    public static ExerciseActivity getInstance() {
        return instance;
    }

    int getScore() {
        return score;
    }
}