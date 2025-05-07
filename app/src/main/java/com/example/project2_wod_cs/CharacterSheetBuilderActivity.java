package com.example.project2_wod_cs;

import static com.example.project2_wod_cs.LandingPage.USERNAME_KEY;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.project2_wod_cs.Database.AppDataRepository;
import com.example.project2_wod_cs.Database.entities.CharacterSheet;
import com.example.project2_wod_cs.Database.entities.User;
import com.example.project2_wod_cs.databinding.ActivityCharacterSheetBuilderBinding;


public class CharacterSheetBuilderActivity extends AppCompatActivity {

    ActivityCharacterSheetBuilderBinding binding;
    private AppDataRepository repository;
    private final int loggedInUserId = -1;
    private String userName = "";
    private int userId;

    private final boolean isVampire = false;
    private final boolean isWizard = false;
    private final boolean isHunter = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCharacterSheetBuilderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = AppDataRepository.getRepository(getApplication());
        userName = getIntent().getStringExtra(USERNAME_KEY);//Imported from the Landing Page activity

        repository.getUserByUserName(userName).observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if(user != null){
                    userId = user.getId();
                }
            }
        });

        CharacterSheet characterSheet = new CharacterSheet(userId);



    }

    private void updateSharedPreference() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefEditor = sharedPreferences.edit();
        sharedPrefEditor.putInt(getString(R.string.preference_userId_key), loggedInUserId);
        sharedPrefEditor.apply();
    }
}