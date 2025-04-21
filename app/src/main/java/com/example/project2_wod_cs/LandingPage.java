package com.example.project2_wod_cs;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project2_wod_cs.databinding.ActivityLandingPageBinding;

public class LandingPage extends AppCompatActivity {

    ActivityLandingPageBinding binding;
    private String username = "";

    private boolean isStoryteller = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLandingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //In the future set up a function to retrieve information either from the previous thing, or the database
        //Place code here

        if(username.isEmpty()){
            username = "Default_Username";
            Log.d("LANDING_PAGE", "Username not properly retrieved from database");
        }

        //If the User is a storyteller it makes the Games button visible.
        if(isStoryteller){
            binding.GamesButton.setVisibility(View.VISIBLE);
        }

        binding.SheetsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LandingPage.this, "No Sheets Functionality Yet", Toast.LENGTH_LONG).show();
            }
        });

        binding.GamesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LandingPage.this, "No Games Functionality Yet", Toast.LENGTH_LONG).show();
            }
        });
    }
}