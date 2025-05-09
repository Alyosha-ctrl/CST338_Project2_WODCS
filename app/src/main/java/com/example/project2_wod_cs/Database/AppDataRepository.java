package com.example.project2_wod_cs.Database;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;

import com.example.project2_wod_cs.Database.entities.CharacterSheet;
import com.example.project2_wod_cs.Database.entities.User;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppDataRepository {
    private ArrayList<User> allUsers;

    private ArrayList<CharacterSheet> allSheets;
    private UserDAO userDAO;
    private CharacterSheetDAO characterSheetDAO;

    private static AppDataRepository repository;

    private AppDataRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        this.userDAO = db.userDAO();
        this.characterSheetDAO = db.characterSheetDAO();
    }

    public  static AppDataRepository getRepository(Application application){

        if(repository != null){
            return repository;
        }

        Future<AppDataRepository> future = AppDatabase.databaseWriteExecutor.submit(new Callable<AppDataRepository>() {
            @Override
            public AppDataRepository call() throws Exception {
                return new AppDataRepository(application);
            }
        });
        try{
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            Log.d("ourapp", "Problem getting AppDataRepository, thread error.");
        }

        return null;
    }


    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public ArrayList<CharacterSheet> getAllSheets() {
        return allSheets;
    }

    public void insertUser(User... user){
        AppDatabase.databaseWriteExecutor.execute(()->{
            userDAO.insert(user);
        });
    }

    public LiveData<User> getUserByUserName(String username) {
        return userDAO.getUserByUsername(username);

    }

    public LiveData<User> getUserByUserId(int userId) {
        return userDAO.getUserByUserId(userId);
    }

    public void insertSheetForUser(CharacterSheet sheet, User user){
        AppDatabase.databaseWriteExecutor.execute(()->{
            characterSheetDAO.insert(sheet);
        });
    }

    public LiveData<CharacterSheet> getSheetByCharacterName(String characterName){
        return characterSheetDAO.getSheetByCharacterName(characterName);
    }

//    public LiveData<CharacterSheet> getSheetByOwnerId(int ownerId){
//        return  characterSheetDAO.getSheetByOwnerId(ownerId);
//    }

    public LiveData<CharacterSheet.UserWithCharacterSheets> getUserWithSheets(int userId){
        return userDAO.getUserWithCharacterSheets(userId);
    }
}
