package com.example.project2_wod_cs.Database;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;

import com.example.project2_wod_cs.Database.entities.User;

import java.util.ArrayList;

public class AppDataRepository {
    private ArrayList<User> allUsers;
    private UserDAO userDAO;

    private AppDataRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        this.userDAO = db.userDAO();

    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public void insertUser(User... user){
        AppDatabase.databaseWriteExecutor.execute(()->{
            userDAO.insert(user);
        });
    }

    public LiveData<User> getUserByUserName(String username) {
        return userDAO.getUserByUsername(username);

    }
}
