package com.example.project2_wod_cs.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.project2_wod_cs.Database.entities.CharacterSheet;
import com.example.project2_wod_cs.Database.entities.Game;
import com.example.project2_wod_cs.Database.entities.User;

@Database(entities = {User.class, CharacterSheet.class, Game.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "WODCSDatabase";
    public static final String CHARACTER_SHEET_TABLE = "characterSheets";
    public static final String USER_TABLE = "userTable";
    public static final String GAME_TABLE = "gameTable";

}
