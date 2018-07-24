package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.bignerdranch.android.libraryactivity.LibraryActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Matthew on 24/07/2018.
 */

public class MainActivityFragment extends Fragment {

    @BindView(R.id.progress_bar)
    public ProgressBar progressBar;
    @BindView(R.id.joke_button)
    public Button button;
    public String jokeResult;
    public boolean testFlag = false;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);

        progressBar.setVisibility(View.GONE);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                tellJoke();
            }
        });

        return root;
    }


    public void tellJoke() {
        new EndpointsAsyncTask().execute(this);
    }

    public void displayJoke(String result) {

        if (!testFlag) {
            Intent intent = new Intent(getContext(), LibraryActivity.class);
            intent.putExtra(LibraryActivity.JOKE, result);
            getContext().startActivity(intent);
            progressBar.setVisibility(View.GONE);
        }
    }
}
