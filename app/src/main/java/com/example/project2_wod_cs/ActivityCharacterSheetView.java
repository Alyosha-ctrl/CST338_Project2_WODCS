package com.example.project2_wod_cs;

import static com.example.project2_wod_cs.LandingPage.USERNAME_KEY;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import com.example.project2_wod_cs.Database.AppDataRepository;
import com.example.project2_wod_cs.databinding.ActivityCharacterSheetViewBinding;

public class ActivityCharacterSheetView extends AppCompatActivity {
    ActivityCharacterSheetViewBinding binding;
    private AppDataRepository repository;
    private int loggedInUserId = -1;
    private String userName = "";

    private boolean textEditable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCharacterSheetViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = AppDataRepository.getRepository(getApplication());
        userName = getIntent().getStringExtra(USERNAME_KEY);//Imported from the Landing Page activity

    }

    private void updateSharedPreference() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefEditor = sharedPreferences.edit();
        sharedPrefEditor.putInt(getString(R.string.preference_userId_key), loggedInUserId);
        sharedPrefEditor.apply();
    }
}