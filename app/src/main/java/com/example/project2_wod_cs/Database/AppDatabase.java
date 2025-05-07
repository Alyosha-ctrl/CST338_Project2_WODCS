package com.example.project2_wod_cs.Database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.project2_wod_cs.Database.entities.CharacterSheet;
import com.example.project2_wod_cs.Database.entities.Game;
import com.example.project2_wod_cs.Database.entities.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class, CharacterSheet.class, Game.class}, version = 6, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "WODCSDatabase";
    public static final String CHARACTER_SHEET_TABLE = "characterSheets";
    public static final String USER_TABLE = "userTable";
    public static final String GAME_TABLE = "gameTable";
    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 6;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private UserDAO userDAO;

    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if(INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,
                            DATABASE_NAME).fallbackToDestructiveMigration(true).addCallback(addDefaultValues).build();
                }
            }
        }
        return INSTANCE;
    }


    private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(()->{
                UserDAO dao = INSTANCE.userDAO();
                dao.deleteAll();
                User storyTeller = new User("storyTeller1","storyTeller1");
                storyTeller.setStoryTeller(true);
                dao.insert(storyTeller);

                User testPlayer = new User("testPlayer", "testPlayer");
                dao.insert(testPlayer);
            });
        }
    };

    public LiveData<User> getUserByUserName(String username) {
        return userDAO.getUserByUsername(username);
    }

    public abstract UserDAO userDAO();

    public abstract CharacterSheetDAO characterSheetDAO();
}
