package ee.ratr.matemaatik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // removes status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // button to Exercise Menu Activity
        Button buttonToExerciseMenu = findViewById(R.id.buttonToExercise);
        buttonToExerciseMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExerciseMenu();
            }
        });

        // button to Info Activity
        Button buttonToInfo = findViewById(R.id.buttonInfo);
        buttonToInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfo();
            }
        });

    }

    private void openInfo() {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    private void openExerciseMenu() {
        Intent intent = new Intent(this, ExerciseMenuActivity.class);
        startActivity(intent);
    }
}