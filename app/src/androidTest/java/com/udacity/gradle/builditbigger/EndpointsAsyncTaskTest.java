package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by Matthew on 20/07/2018.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Before
    public void stubAllExternalIntents() {
        // block all external intents
        intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }


    @Test
    public void doInBackground() throws Exception {


        MainActivityFragment mainActivityFragment = new MainActivityFragment();
        new EndpointsAsyncTask().execute(mainActivityFragment).get(20, TimeUnit.SECONDS);
        assertTrue("The joke is not an empty string", mainActivityFragment.jokeResult != null);

    }


}