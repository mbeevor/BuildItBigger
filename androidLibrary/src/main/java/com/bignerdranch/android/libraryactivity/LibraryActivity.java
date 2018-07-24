package com.bignerdranch.android.libraryactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LibraryActivity extends AppCompatActivity {

    public final static String JOKE = "joke";

    String jokeString;
    TextView jokeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        jokeTv = findViewById(R.id.joke_tv);

        Intent intent = getIntent();
        if (intent != null) {
            jokeString = intent.getStringExtra(JOKE);
            jokeTv.setText(jokeString);
        }

    }
}
