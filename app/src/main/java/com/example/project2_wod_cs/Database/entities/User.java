package com.example.project2_wod_cs.Database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.project2_wod_cs.Database.AppDatabase;

import java.util.Objects;

@Entity(tableName = AppDatabase.USER_TABLE)
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String username;
    private String password;
    private boolean isStoryTeller;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.isStoryTeller = false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && isStoryTeller == user.isStoryTeller && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, isStoryTeller);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
