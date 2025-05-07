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

//        binding.rollButton.setOnClickListener(new View.OnClickListener() {
//            for(i = 0; i >= diceAmount;
//        });

        binding.rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDiceAmount();
                rollDice(diceAmount);
            }
        });

    }



    private int getDiceAmount (){
        try{
            diceAmount = Integer.parseInt(binding.diceAmountEditText.getText().toString());
        } catch (NumberFormatException e) {
            Log.d("Input number format exception", "");
        }
        if(diceAmount <= 0){
        }
    }

    static Intent buttonRollIntentFactory(Context context){return new Intent(context, ButtonRoll.class);};

    private void rollDice (int number){
        Random random = new Random();

        number = random.nextInt(1,7);
        System.out.println(number);
    }
}


