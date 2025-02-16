package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private TextView resultText;
    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultText = findViewById(R.id.resultText);
        shareButton = findViewById(R.id.shareButton);

        int finalScore = getIntent().getIntExtra("finalScore", 0);
        resultText.setText("Your Score: " + finalScore);

        shareButton.setOnClickListener(view -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "I scored " + finalScore + " in the quiz app. Can you????");
            startActivity(Intent.createChooser(shareIntent, "Share using "));
        });
    }
}
