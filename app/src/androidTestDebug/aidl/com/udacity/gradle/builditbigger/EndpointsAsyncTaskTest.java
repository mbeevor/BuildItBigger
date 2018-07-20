package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;


/**
 * Created by Matthew on 17/07/2018.
 */

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void endpointsAsyncTaskTest() throws Exception {

        MainActivityFragment mainActivityFragment = new MainActivityFragment();
        new EndpointsAsyncTask().execute(mainActivityFragment).get(20, TimeUnit.SECONDS);
        assertTrue("The joke is not an empty string", mainActivityFragment.jokeResult != null);

    }
}