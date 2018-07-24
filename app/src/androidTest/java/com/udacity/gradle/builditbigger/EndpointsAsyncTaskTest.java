package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertFalse;

/**
 * Created by Matthew on 20/07/2018.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {



    @Test
    public void doInBackground() throws Exception {

        MainActivityFragment mainActivityFragment = new MainActivityFragment();
        mainActivityFragment.testFlag = true;
        new EndpointsAsyncTask().execute(mainActivityFragment).get(20, TimeUnit.SECONDS);
        assertFalse("The joke is not an empty string" + mainActivityFragment.jokeResult, mainActivityFragment.jokeResult != null);

    }


}