package com.example.project2_wod_cs;

import static com.example.project2_wod_cs.MainActivity.LOGGED_OUT;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.project2_wod_cs.Database.AppDataRepository;
import com.example.project2_wod_cs.Database.entities.CharacterSheet;
import com.example.project2_wod_cs.Database.entities.User;
import com.example.project2_wod_cs.databinding.ActivityMetaSheetsBinding;

import java.util.ArrayList;
import java.util.List;

public class MetaSheets extends AppCompatActivity {

    ActivityMetaSheetsBinding binding;

    public static final String USERNAME_KEY = "user_id";

    private ArrayList<String> names = new ArrayList<>();

    private AppDataRepository repository;
    private String username = "";

    private String destination = "hnv-9uwahgas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMetaSheetsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = AppDataRepository.getRepository(getApplication());
        username = getIntent().getStringExtra(USERNAME_KEY);

        //A method to turn whats in the user to a list of names.
        getSheetNameList();


        AutoCompleteTextView spinner = binding.autoCompleteText;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, names);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                destination = parent.getItemAtPosition(position).toString();
            }
        });

        binding.sheetGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSheet();
            }
        });

        binding.sheetBuilderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSheetBuilder();
            }
        });

        binding.returnToLandingPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(LandingPage.landingPageIntentFactory(getApplicationContext(), username));
            }
        });
    }

    static Intent metaSheetsIntentFactory(Context context, String username){
        Intent intent = new Intent(context, MetaSheets.class);
        intent.putExtra(USERNAME_KEY, username);
        return intent;
    }

    private void startSheet(){
        if(destination.equals("hnv-9uwahgas")){
            toastMaker("To Move On Requires You to Choose An Option");
            return;
        }
        startActivity(ActivityCharacterSheetView.activityCharacterSheetViewIntentFactory(getApplicationContext()));
        toastMaker("Cannot get to sheet " + destination + ".\nThe sheet activity does not currently exist");
    }

    private void startSheetBuilder(){
        startActivity(CharacterSheetBuilderActivity.characterSheetBuilderActivityIntentFactory(getApplicationContext()));
    }

    private void toastMaker(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void getSheetNameList(){
        names.clear();
        names.add("Slinky the Magnificent");
        names.add("Bloodsucker");
        names.add("Begger");
        names.add("Sucker");
    }
}