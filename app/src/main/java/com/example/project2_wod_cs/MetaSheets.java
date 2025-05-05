package com.example.project2_wod_cs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project2_wod_cs.Database.AppDataRepository;
import com.example.project2_wod_cs.databinding.ActivityMetaSheetsBinding;

public class MetaSheets extends AppCompatActivity {

    ActivityMetaSheetsBinding binding;

    public static final String USERNAME_KEY = "user_id";

    private AppDataRepository repository;
    private String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMetaSheetsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = AppDataRepository.getRepository(getApplication());
        username = getIntent().getStringExtra(USERNAME_KEY);
    }

    static Intent metaSheetsIntentFactory(Context context, String username){
        Intent intent = new Intent(context, MetaSheets.class);
        intent.putExtra(USERNAME_KEY, username);
        return intent;
    }
}