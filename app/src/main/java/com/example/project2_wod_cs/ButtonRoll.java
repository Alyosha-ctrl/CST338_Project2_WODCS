package com.example.project2_wod_cs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import com.example.project2_wod_cs.Database.AppDataRepository;
import com.example.project2_wod_cs.Database.UserDAO;
import com.example.project2_wod_cs.Database.entities.User;
import com.example.project2_wod_cs.databinding.ActivityButtonRollBinding;

import java.util.Random;

public class ButtonRoll extends AppCompatActivity{

    private int diceAmount;
    ActivityButtonRollBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityButtonRollBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayDice();
            }
        });

    }

    private int getDiceAmount (){
        //returns the amount of dice to roll as an int
        try{
            diceAmount = Integer.parseInt(binding.diceAmountEditText.getText().toString());
        } catch (NumberFormatException e) {
            Log.d("Input number format exception", "");
        }
        if(diceAmount <= 0){
        }
        return diceAmount;
    }

    static Intent buttonRollIntentFactory(Context context){return new Intent(context, ButtonRoll.class);};

    private String rollDice (int diceAmount){
        //random number generator
        int number;
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i <= diceAmount; i++){
            //loop that appends a random number to the display string
            number = random.nextInt(11);
            result.append(random);
            result.append(" ");
        }

        return result.toString();
    }


    private void displayDice (){
        //sets the TextView to the numbers rolled from the random number generator
        String display = rollDice(getDiceAmount());
        binding.diceDisplayTextView.setText(display);
    }
}



