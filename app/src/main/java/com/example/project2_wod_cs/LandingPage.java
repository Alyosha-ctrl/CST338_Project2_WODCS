package com.example.project2_wod_cs;

import static com.example.project2_wod_cs.MainActivity.LOGGED_OUT;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.project2_wod_cs.Database.AppDataRepository;
import com.example.project2_wod_cs.Database.entities.User;
import com.example.project2_wod_cs.databinding.ActivityLandingPageBinding;

public class LandingPage extends AppCompatActivity {

    ActivityLandingPageBinding binding;
    public static final String USERNAME_KEY = "user_id";
    private AppDataRepository repository;
    private String username = "";
    private int loggedInUserId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityLandingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = AppDataRepository.getRepository(getApplication());
        username = getIntent().getStringExtra(USERNAME_KEY);

        /*repository.getUserByUserName(username).observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                loggedInUserId = user.getId();
            }
        });*/

        /*This is how we have to get any data from a multi field object stored in a LiveData
        * Object, Observers are the only way to go*/
        repository.getUserByUserName(username).observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if(user != null && user.isStoryTeller()){
                    binding.storytellerButton.setVisibility(View.VISIBLE);
                }
            }
        });


        binding.tempLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loggedInUserId = LOGGED_OUT;
                updateSharedPreference();
                startActivity(LogIn.loginIntentFactory(getApplicationContext()));
            }
        });

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

        binding.welcomeText.setText("Welcome " + username);
    }


    private void updateSharedPreference() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefEditor = sharedPreferences.edit();
        sharedPrefEditor.putInt(getString(R.string.preference_userId_key), loggedInUserId);
        sharedPrefEditor.apply();
    }

    private void startPlayer(){
        startActivity(MetaSheets.metaSheetsIntentFactory(getApplicationContext(), username));
    }

    //Comment here so I can push stuff.
    private void startStoryteller(){
        Toast.makeText(LandingPage.this, "Storyteller Not Currently Implemented", Toast.LENGTH_LONG).show();
    }

    static Intent landingPageIntentFactory(Context context, String username){
        Intent intent = new Intent(context, LandingPage.class);
        intent.putExtra(USERNAME_KEY, username);
        return intent;
    }
}
