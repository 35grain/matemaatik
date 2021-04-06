package com.example.matemaatik;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.matemaatik.equations.Add;
import com.example.matemaatik.equations.Equation;

public class ExerciseActivity extends AppCompatActivity {
    int i;
    private Add add;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        //no structure adding
        Equation add = new Add(50, 10);
        TextView textViewChange = (TextView) findViewById(R.id.addText);
        textViewChange.setText(add.toString());
    }

    public void getAwnser(View v) {
        TextView t = findViewById(R.id.awnser);
        i = Integer.parseInt(t.getText().toString());

        Log.d("info", t.getText().toString());
    }
}