package com.example.project2_wod_cs;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.project2_wod_cs.Database.AppDatabase;
import com.example.project2_wod_cs.Database.UserDAO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DatabaseTester {
    private AppDatabase db;
    public static final String LOG_TAG = "DatabaseTester";

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        Log.d(LOG_TAG, db.toString());
    }

    @After
    public void closeDb(){
        db.close();
    }

    @Test
    public void insertUser(){

    }

    @Test
    public void updateUser(){

    }

    @Test
    public void deleteUser(){

    }

    @Test
    public void insertCharacterSheet(){

    }

    @Test
    public void updateCharacterSheet(){

    }

    @Test
    public void deleteCharacterSheet(){

    }
}
