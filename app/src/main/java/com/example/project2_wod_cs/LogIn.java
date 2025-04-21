package com.example.project2_wod_cs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import com.example.project2_wod_cs.Database.AppDataRepository;
import com.example.project2_wod_cs.Database.UserDAO;
import com.example.project2_wod_cs.Database.entities.User;
import com.example.project2_wod_cs.databinding.ActivityLogInBinding;

public class LogIn extends AppCompatActivity {

    ActivityLogInBinding binding;
    
    private AppDataRepository repository;

    private String username = "";
    private String password = "";
    private String passwordAgain = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = new AppDataRepository(getApplication());

        binding.logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyUser();
            }
        });

        binding.SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LandingPage.class);
                startActivity(intent);
            }
        });
    }

    @Deprecated
    private boolean getInformationFromDisplay(){
        username = binding.UsernameInputEditText.getText().toString();
        password = binding.PasswordInputEditText.getText().toString();
        passwordAgain = binding.PasswordAgainInputEditText.getText().toString();
        if(password.equals(passwordAgain)){
            toastMaker("Succesfully Entered Log In Information");
            return true;
        }
        toastMaker("Password, Not Equal to Password Again");
        return false;
    }

    private void verifyUser() {
        username = binding.UsernameInputEditText.getText().toString();
        if(username.isEmpty()){
            toastMaker("Username may not be blank");
            return;
        }
        LiveData<User> userObserver = repository.getUserByUserName(username);
        userObserver.observe(this, user -> {
            if(user != null){
                String password = binding.PasswordInputEditText.getText().toString();
                if(password.equals(user.getPassword())){
                    Intent intent = LandingPage.landingPageIntentFactory(getApplicationContext(), user.getId());
                    startActivity(intent);
//                    startActivity(MainActivity.getMainActivityIntentFactory(getApplicationContext(), user.getId()));
                }
                else{
                    toastMaker("Invalid Password");
                    binding.PasswordInputEditText.setSelection(0);
                }
            }
            else{
                toastMaker(String.format("%s is not a valid username.", username));
                binding.PasswordInputEditText.setSelection(0);
            }
        });

    }

    private void toastMaker(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    static Intent loginIntentFactory(Context context){
        return new Intent(context, LogIn.class);
    }
}