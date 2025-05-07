package com.example.project2_wod_cs;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.util.Random;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    public static final String LOG_TAG = "ExampleInstrumentedTest";
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.project2_wod_cs", appContext.getPackageName());
    }

    //Alexey "Azriel" Berezhnoy's Activity Intent Factory Tests
    @Test
    public void logInIntentFactory() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = LogIn.loginIntentFactory((appContext));
        Log.d(LOG_TAG, intent.getComponent().getClassName());
        assertEquals(LogIn.class.getName(), intent.getComponent().getClassName());
    }

    @Test
    public void signUpIntentFactory() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = SignUp.signUpIntentFactory(appContext);
        Log.d(LOG_TAG, intent.getComponent().getClassName());
        assertEquals(SignUp.class.getName(), intent.getComponent().getClassName());
    }

    @Test
    public void metaSheetsIntentFactory() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        String exampleName="goober";
        Intent intent = MetaSheets.metaSheetsIntentFactory(appContext, exampleName);
        Log.d(LOG_TAG, intent.getComponent().getClassName());
        assertEquals(MetaSheets.class.getName(), intent.getComponent().getClassName());
        assertEquals(exampleName, intent.getStringExtra(MetaSheets.USERNAME_KEY));
    }

    //Nikolii Proud's Activity Intent Factory Tests
    @Test
    public void sheetIntentFactory(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = ActivityCharacterSheetView.activityCharacterSheetViewIntentFactory(appContext);
        Log.d(LOG_TAG, intent.getComponent().getClassName());
        assertEquals(ActivityCharacterSheetView.class.getName(), intent.getComponent().getClassName());
    }

    @Test
    public void sheetBuilderIntentFactory(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = CharacterSheetBuilderActivity.characterSheetBuilderActivityIntentFactory(appContext);
        Log.d(LOG_TAG, intent.getComponent().getClassName());
        assertEquals(CharacterSheetBuilderActivity.class.getName(), intent.getComponent().getClassName());
    }
    //Antonio Barron's Activity Intent Factory Tests
    @Test
    public void landingPageIntentFactory(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        String exampleName="goober";
        Intent intent = LandingPage.landingPageIntentFactory(appContext, exampleName);
        Log.d(LOG_TAG, intent.getComponent().getClassName());
        assertEquals(LandingPage.class.getName(), intent.getComponent().getClassName());
        assertEquals(exampleName, intent.getStringExtra(LandingPage.USERNAME_KEY));
    }

    @Test
    public void buttonRollPageIntentFactory(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = ButtonRoll.buttonRollIntentFactory(appContext);
        Log.d(LOG_TAG, intent.getComponent().getClassName());
        assertEquals(ButtonRoll.class.getName(), intent.getComponent().getClassName());
    }
}