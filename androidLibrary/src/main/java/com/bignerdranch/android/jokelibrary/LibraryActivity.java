package com.bignerdranch.android.jokelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.ButterKnife;

public class LibraryActivity extends AppCompatActivity {

    String jokeString;
    TextView jokeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        ButterKnife.bind(this);

        jokeTv = findViewById(R.id.joke_tv);

        Intent intent = getIntent();
        if (intent != null) {
            jokeString = intent.getStringExtra("joke");
            jokeTv.setText(jokeString);
        }

    }
}
