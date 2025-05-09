package com.example.project2_wod_cs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private int loggedInUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = AppDataRepository.getRepository(getApplication());

        binding.logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyUser();
            }
        });

        binding.SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SignUp.signUpIntentFactory(getApplicationContext()));
            }
        });
    }

    @Deprecated
    private boolean getInformationFromDisplay(){
        username = binding.UsernameInputEditText.getText().toString();
        password = binding.PasswordInputEditText.getText().toString();
        //passwordAgain = binding.PasswordAgainInputEditText.getText().toString();
        if(password.equals(passwordAgain)){
            toastMaker("Successfully Entered Log In Information");
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
                    toastMaker("Login Success");
                    updateSharedPreference();
                    Intent intent = LandingPage.landingPageIntentFactory(getApplicationContext(), user.getUsername());
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

    private void updateSharedPreference() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefEditor = sharedPreferences.edit();
        sharedPrefEditor.putInt(getString(R.string.preference_userId_key), loggedInUserId);
        sharedPrefEditor.apply();
    }

    private void startLogIn(){
        Log.d("LOG_IN", "startLogInCannotBeCompletedWithoutDatabase");
    }

    static Intent loginIntentFactory(Context context){
        return new Intent(context, LogIn.class);
    }
}