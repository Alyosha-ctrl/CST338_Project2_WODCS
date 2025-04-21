package com.example.project2_wod_cs;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project2_wod_cs.databinding.ActivityLogInBinding;

public class LogIn extends AppCompatActivity {

    ActivityLogInBinding binding;

    private String username = "";
    private String password = "";
    private String passwordAgain = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getInformationFromDisplay()){
                    startLogIn();
                }
            }
        });

        binding.SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LogIn.this, "No Sign Up Functionality Yet", Toast.LENGTH_LONG).show();
                //Jury rigged stuff just to test out the page and see if it works
                Intent intent = new Intent(getApplicationContext(), LandingPage.class);
                startActivity(intent);
            }
        });
    }

    private boolean getInformationFromDisplay(){
        username = binding.UsernameInputEditText.getText().toString();
        password = binding.PasswordInputEditText.getText().toString();
        passwordAgain = binding.PasswordAgainInputEditText.getText().toString();
        if(password.equals(passwordAgain)){
            Toast.makeText(LogIn.this, "Succesfully Entered Log In Information", Toast.LENGTH_SHORT).show();
            return true;
        }
        Toast.makeText(LogIn.this, "Password, Not Equal to Password Again", Toast.LENGTH_LONG).show();
        return false;
    }
    private void startLogIn(){
        Log.d("LOG_IN", "startLogInCannotBeCompletedWithoutDatabase");
    }
}