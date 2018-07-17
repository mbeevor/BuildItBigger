package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.bignerdranch.android.LibraryActivity.LibraryActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @BindView(R.id.progress_bar) public ProgressBar progressBar;
    @BindView(R.id.joke_button) public Button button;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        progressBar.setVisibility(View.GONE);

        button.setOnClickListener(new View.OnClickListener(){

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

        Intent intent = new Intent(getContext(), LibraryActivity.class);
        Log.d("joke = ", result);
        intent.putExtra("joke", result);
        getContext().startActivity(intent);
        progressBar.setVisibility(View.GONE);

    }
}
