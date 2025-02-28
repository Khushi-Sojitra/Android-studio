package com.example.recipeapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class RecipeDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        TextView title = findViewById(R.id.recipeTitleTextView);
        TextView ingredients = findViewById(R.id.recipeIngredientsTextView);
        TextView instructions = findViewById(R.id.recipeInstructionsTextView);

        String recipeTitle = getIntent().getStringExtra("RECIPE_TITLE");
        ArrayList<String> recipeIngredients = getIntent().getStringArrayListExtra("RECIPE_INGREDIENTS");
        String recipeInstructions = getIntent().getStringExtra("RECIPE_INSTRUCTIONS");

        title.setText(recipeTitle);
        ingredients.setText("Ingredients:\n" + String.join("\n", recipeIngredients));
        instructions.setText("Instructions:\n" + recipeInstructions);
    }
}
