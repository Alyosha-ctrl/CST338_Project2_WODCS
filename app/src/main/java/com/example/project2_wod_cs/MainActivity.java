/**
 * Will become landing page
 */
package com.example.project2_wod_cs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import com.example.project2_wod_cs.Database.AppDataRepository;
import com.example.project2_wod_cs.Database.entities.User;
import com.example.project2_wod_cs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final int LOGGED_OUT = -1;
    public static final String TAG = "OUrApp";
    private static final String MAIN_ACTIVITY_USER_ID = "com.example.project2_wod_cs.MAIN_ACTIVITY_USER_ID";
    private static final String SAVED_INSTANCE_STATE_USERID_KEY = "com.example.project2_wod_cs.SAVED_INSTANCE_STATE_USERID_KEY";
    private int loggedInUserId = -1;
    ActivityMainBinding binding;
    private AppDataRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = AppDataRepository.getRepository(getApplication());
        loginUser(savedInstanceState);

        invalidateOptionsMenu();

        if(loggedInUserId == LOGGED_OUT){
            Intent intent = LogIn.loginIntentFactory((getApplicationContext()));
            startActivity(intent);
        }

        updateSharedPreference();

        binding.logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LogIn.class);
                startActivity(intent);
            }
        });

        binding.SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignUp();
            }
        });
    }

    private void loginUser(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        if(loggedInUserId == LOGGED_OUT & savedInstanceState != null && savedInstanceState.containsKey(SAVED_INSTANCE_STATE_USERID_KEY)){
            loggedInUserId = savedInstanceState.getInt(SAVED_INSTANCE_STATE_USERID_KEY, LOGGED_OUT);
        }

        if(loggedInUserId == LOGGED_OUT){
            loggedInUserId = getIntent().getIntExtra(MAIN_ACTIVITY_USER_ID, LOGGED_OUT);
        }

        if(loggedInUserId == LOGGED_OUT){
            return;
        }

        //check intent for logged in user
        loggedInUserId = getIntent().getIntExtra(MAIN_ACTIVITY_USER_ID, LOGGED_OUT);
        if(loggedInUserId == LOGGED_OUT){
            return;
        }
        LiveData<User> userObserver = repository.getUserByUserId(loggedInUserId);
        userObserver.observe(this, user -> {
            if(user != null){
                invalidateOptionsMenu();
            }

        });
    }

    private void logOut(){
        loggedInUserId = LOGGED_OUT;
        updateSharedPreference();
        getIntent().putExtra(MAIN_ACTIVITY_USER_ID, LOGGED_OUT);
        startActivity(LogIn.loginIntentFactory(getApplicationContext()));
    }

    private void updateSharedPreference() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefEditor = sharedPreferences.edit();
        sharedPrefEditor.putInt(getString(R.string.preference_userId_key), loggedInUserId);
        sharedPrefEditor.apply();
    }

    static Intent mainActivityIntentFactory(Context context, int userId){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MAIN_ACTIVITY_USER_ID, userId);
        return intent;
    }

    private void startSignUp(){
        startActivity(SignUp.signUpIntentFactory(getApplicationContext()));
    }
}