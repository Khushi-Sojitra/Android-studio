package com.example.recipeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button veganButton = findViewById(R.id.veganButton);
        Button vegetarianButton = findViewById(R.id.vegetarianButton);
        Button nonVegButton = findViewById(R.id.nonVegButton);

        veganButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipeList("vegan");
            }
        });

        vegetarianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipeList("vegetarian");
            }
        });

        nonVegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipeList("nonveg");
            }
        });
    }

    private void openRecipeList(String category) {
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        intent.putExtra("CATEGORY", category);
        startActivity(intent);
    }
}
