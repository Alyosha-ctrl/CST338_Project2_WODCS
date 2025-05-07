package com.example.project2_wod_cs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project2_wod_cs.Database.AppDataRepository;
import com.example.project2_wod_cs.Database.UserDAO;
import com.example.project2_wod_cs.Database.entities.User;
import com.example.project2_wod_cs.databinding.ActivityLogInBinding;
import com.example.project2_wod_cs.databinding.ActivitySignUpBinding;

public class SignUp extends AppCompatActivity {

    ActivitySignUpBinding binding;

    private AppDataRepository repository;

    private String username = "";
    private String password = "";
    private String passwordAgain = "";
    private boolean isStoryTeller = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = AppDataRepository.getRepository(getApplication());



        binding.isStoryTellerCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isStoryTeller = binding.isStoryTellerCheckBox.isChecked();
            }
        });

        binding.SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getInformationFromDisplay()){
                    User newUser = new User(username,password);
                    try {
                        newUser.setStoryTeller(isStoryTeller);
                    } catch (Exception e) {
                        //If no isStoryTeller is called makes it false by default
                        newUser.setStoryTeller(false);
                    }
                    repository.insertUser(newUser);
                    startActivity(LogIn.loginIntentFactory(getApplicationContext()));
                }
            }
        });

        binding.ReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(LogIn.loginIntentFactory(getApplicationContext()));
            }
        });

    }
    private boolean getInformationFromDisplay(){
        username = binding.UsernameInputEditText.getText().toString();
        password = binding.PasswordInputEditText.getText().toString();
        passwordAgain = binding.PasswordAgainInputEditText.getText().toString();
        if(password.equals(passwordAgain)){
            toastMaker("Successfully Entered Sign Up Information");
            return true;
        }
        toastMaker("Password, Not Equal to Password Again");
        return false;
    }

    private void toastMaker(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    public static Intent signUpIntentFactory(Context context){
        return new Intent(context, SignUp.class);
    }
}