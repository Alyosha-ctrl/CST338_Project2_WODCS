package com.example.project2_wod_cs;

import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.project2_wod_cs.Database.AppDataRepository;
import com.example.project2_wod_cs.Database.AppDatabase;
import com.example.project2_wod_cs.Database.UserDAO;
import com.example.project2_wod_cs.Database.entities.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Objects;

@RunWith(AndroidJUnit4.class)
public class DatabaseTester {
    private AppDatabase db;
    private UserDAO userDAO;
    public static final String LOG_TAG = "DatabaseTester";

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        userDAO = db.userDAO();
        Log.d(LOG_TAG, db.toString());
    }

    @After
    public void closeDb(){
        db.close();
    }

    @Test
    public void insertUser(){
        User testPlayer = new User("testPlayer", "testPlayer");
        userDAO.insert(testPlayer);
        User[] testUser = new User[1];
        db.getUserByUserName("testPlayer").observe((LifecycleOwner) this, user -> {
                    if(user != null){
                        testUser[0] = user;
                    }
                });
        Log.d(LOG_TAG, testUser[0].getUsername());
        assertEquals(testPlayer.getUsername(), testUser[0].getUsername());
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
