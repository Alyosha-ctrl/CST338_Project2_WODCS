package com.example.project2_wod_cs;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project2_wod_cs.databinding.ActivityLogInBinding;

public class LogIn extends AppCompatActivity {

    ActivityLogInBinding binding;

    String username = "";
    String password = "";
    String passwordAgain = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay();
                Toast.makeText(LogIn.this, "It Worked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateDisplay(){
        Log.d("LOG_IN", "Update Display Not Finished Yet");
    }
}