package com.example.project2_wod_cs.Database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.project2_wod_cs.Database.AppDatabase;

@Entity(tableName = AppDatabase.CHARACTER_SHEET_TABLE)
public class CharacterSheet {
    @PrimaryKey(autoGenerate = true)
    private int id;
}
