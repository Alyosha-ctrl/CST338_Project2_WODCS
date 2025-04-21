package com.example.project2_wod_cs.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.project2_wod_cs.Database.entities.Game;

@Dao
public interface GameDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Game game);
}
