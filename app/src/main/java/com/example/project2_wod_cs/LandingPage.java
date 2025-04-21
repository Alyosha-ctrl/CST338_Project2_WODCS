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

    private String username = "";
    private Boolean isStoryteller = true;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityLandingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
        if(username.isEmpty()){
            username = "Default_User";
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

    static Intent loginIntentFactory(Context context){
        return new Intent(context, LogIn.class);
    }
}
