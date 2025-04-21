package com.example.project2_wod_cs.Database;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;

import com.example.project2_wod_cs.Database.entities.User;

import java.util.ArrayList;

public class AppDataRepository {
    private ArrayList<User> allUsers;
    private UserDAO userDAO;

    public AppDataRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        this.userDAO = db.userDAO();

    }

    //TODO MAKE A NEW METHOD TO MAKE REPOSITORIES IN A SINGLETON MANNER

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
