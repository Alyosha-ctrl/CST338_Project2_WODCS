package com.example.project2_wod_cs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project2_wod_cs.Database.AppDataRepository;
import com.example.project2_wod_cs.databinding.ActivityLandingPageBinding;

public class LandingPage extends AppCompatActivity {

    ActivityLandingPageBinding binding;
    public static final String USERNAME_KEY = "user_id";
    private AppDataRepository repository;
    private String username = "";
    private Boolean isStoryteller = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityLandingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = AppDataRepository.getRepository(getApplication());
        username = getIntent().getStringExtra(USERNAME_KEY);
        try {
            isStoryteller = repository.getUserByUserName(username).getValue().isStoryTeller();
        } catch (NullPointerException e) {
            Log.d("landing_page", "isStoryTeller returned a null pointer using the default of false");
        }



        binding.playerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {startPlayer();}
        });

        binding.storytellerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStoryteller();
            }
        });

        if(isStoryteller){
            binding.storytellerButton.setVisibility(View.VISIBLE);
        }

        username = "Welcome " + username;
        binding.welcomeText.setText(username);
    }


    private void startPlayer(){
        Toast.makeText(LandingPage.this, "Player Not Currently Implemented", Toast.LENGTH_LONG).show();
    }

    private void startStoryteller(){
        Toast.makeText(LandingPage.this, "Storyteller Not Currently Implemented", Toast.LENGTH_LONG).show();
    }

    static Intent landingPageIntentFactory(Context context, String username){
        Intent intent = new Intent(context, LandingPage.class);
        intent.putExtra(USERNAME_KEY, username);
        return intent;
    }
}
