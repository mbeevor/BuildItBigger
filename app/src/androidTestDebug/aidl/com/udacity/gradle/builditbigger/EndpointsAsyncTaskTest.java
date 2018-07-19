package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.TimeUnit;


/**
 * Created by Matthew on 17/07/2018.
 */

public class EndpointsAsyncTaskTest extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void endpointsAsyncTaskTest() {

        String joke = " ";

        try {
            joke = new EndpointsAsyncTask().execute().get(20, TimeUnit.SECONDS);
        } catch (Exception e) {
            fail();
        }

        assertNotNull("The joke fetched is: ", joke);
        assertTrue("The joke is an empty string", joke.length() > 0);
    }
}