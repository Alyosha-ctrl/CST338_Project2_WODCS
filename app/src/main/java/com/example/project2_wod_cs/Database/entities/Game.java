package com.example.project2_wod_cs.Database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.project2_wod_cs.Database.AppDatabase;

@Entity(tableName = AppDatabase.GAME_TABLE)
public class Game {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String gameName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
