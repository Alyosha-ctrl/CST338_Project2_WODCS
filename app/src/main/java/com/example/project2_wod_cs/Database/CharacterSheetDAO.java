package com.example.project2_wod_cs.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.project2_wod_cs.Database.entities.CharacterSheet;
import com.example.project2_wod_cs.Database.entities.User;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CharacterSheetDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CharacterSheet characterSheet);

    @Delete
    void delete(CharacterSheet sheet);

    @Query("SELECT * FROM " + AppDatabase.CHARACTER_SHEET_TABLE + " ORDER BY characterName")
    LiveData<List<CharacterSheet>> getAllSheets();

    @Query("SELECT * FROM " + AppDatabase.CHARACTER_SHEET_TABLE + " WHERE characterName == :characterName")
    LiveData<CharacterSheet> getSheetByCharacterName(String characterName);

    @Query("SELECT * FROM " + AppDatabase.CHARACTER_SHEET_TABLE + " WHERE  ownerId == :ownerId")
    LiveData<List<CharacterSheet>> getSheetByOwnerId(int ownerId);
}
