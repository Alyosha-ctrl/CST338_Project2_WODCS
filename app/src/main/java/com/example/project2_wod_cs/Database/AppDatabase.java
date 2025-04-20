package com.example.project2_wod_cs.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.project2_wod_cs.Database.entities.CharacterSheet;
import com.example.project2_wod_cs.Database.entities.Game;
import com.example.project2_wod_cs.Database.entities.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class, CharacterSheet.class, Game.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "WODCSDatabase";
    public static final String CHARACTER_SHEET_TABLE = "characterSheets";
    public static final String USER_TABLE = "userTable";
    public static final String GAME_TABLE = "gameTable";
    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 6;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static AppDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (AppDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration(true).addCallback(addDefaultValues).build();
            }
        }
        return INSTANCE;
    }


    private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            //TODO: create a tag so we can see this works in the logcat or app inspection window
            //TODO: Use databaseWriteExecutor.execute(() -> {...}
        }
    }
