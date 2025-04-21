package com.example.project2_wod_cs.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.project2_wod_cs.Database.entities.CharacterSheet;

@Dao
public interface CharacterSheetDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CharacterSheet characterSheet);
}
