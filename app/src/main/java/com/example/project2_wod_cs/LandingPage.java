package com.example.project2_wod_cs;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project2_wod_cs.databinding.ActivityLandingPageBinding;

public class LandingPage extends AppCompatActivity {

    ActivityLandingPageBinding binding;
    private String username = "";

    private boolean isStoryteller = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLandingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //In the future set up a function to retrieve information either from the previous thing, or the database
        //Place code here

        if(username.equals("")){
            username = "Default_Username";
            Log.d("LANDING_PAGE", "Username not properly retrieved from database");
        }

        if(isStoryteller){
            binding.GamesButton.setVisibility(View.VISIBLE);
        }
    }
}