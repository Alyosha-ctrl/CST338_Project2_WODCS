/**
 * Will become landing page
 */
package com.example.project2_wod_cs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.project2_wod_cs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
    private void startSignUp(){
        Toast.makeText(MainActivity.this, "Sign Up Not Currently Implemented", Toast.LENGTH_LONG).show();
    }
}