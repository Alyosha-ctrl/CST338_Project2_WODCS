/**
 * Will becom landing page
 */
package com.example.project2_wod_cs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.project2_wod_cs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final int LOGGED_OUT = -1;
    private static final String MAIN_ACTIVITY_USER_ID = "com.example.project2_wod_cs.MAIN_ACTIVITY_USER_ID";
    private int loggedInUserId = -1;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginUser();

        if(loggedInUserId == LOGGED_OUT){
            Intent intent = LogIn.loginIntentFactory((getApplicationContext()));
            startActivity(intent);
        }

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

    private void loginUser() {
        loggedInUserId = getIntent().getIntExtra(MAIN_ACTIVITY_USER_ID, LOGGED_OUT);
    }

    static Intent mainActivityIntentFactory(Context context, int userId){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MAIN_ACTIVITY_USER_ID, userId);
        return intent;
    }

    private void startSignUp(){
        Toast.makeText(MainActivity.this, "Sign Up Not Currently Implemented", Toast.LENGTH_LONG).show();
    }
}