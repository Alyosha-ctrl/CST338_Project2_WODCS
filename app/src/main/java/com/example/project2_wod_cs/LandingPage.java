package com.example.project2_wod_cs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.project2_wod_cs.databinding.ActivityLandingPageBinding;

public class LandingPage extends AppCompatActivity {
    ActivityLandingPageBinding binding;
    public static final String USERNAME_KEY = "user_id";
    private String username = "";
    private Boolean isStoryteller = true;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityLandingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        username = getIntent().getStringExtra(USERNAME_KEY);


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
