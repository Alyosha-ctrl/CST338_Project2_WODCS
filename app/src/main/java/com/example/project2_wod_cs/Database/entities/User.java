package com.example.project2_wod_cs.Database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.project2_wod_cs.Database.AppDatabase;

@Entity(tableName = AppDatabase.USER_TABLE)
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

private String username;
private String password;
private boolean isStoryTeller = false;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.isStoryTeller = false;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStoryTeller() {
        return isStoryTeller;
    }

    public void setStoryTeller(boolean storyTeller) {
        isStoryTeller = storyTeller;
    }
}
