package com.example.project2_wod_cs;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.project2_wod_cs", appContext.getPackageName());
    }

    @Test
    public void logInIntentFactory() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = LogIn.loginIntentFactory((appContext));
        assertEquals(LogIn.class.getName(), intent.getComponent().getClassName());
    }

    @Test
    public void signUpIntentFactory() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = SignUp.signUpIntentFactory(appContext);
        assertEquals(SignUp.class.getName(), intent.getComponent().getClassName());
    }

    @Test
    public void metaSheetsIntentFactory() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        String exampleName="goober";
        Intent intent = MetaSheets.metaSheetsIntentFactory(appContext, exampleName);
        assertEquals(MetaSheets.class.getName(), intent.getComponent().getClassName());
        assertEquals(exampleName, intent.getStringExtra(MetaSheets.USERNAME_KEY));
    }
}