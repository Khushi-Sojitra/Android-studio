package com.example.recipeapp;

import java.util.List;

public class Recipe {
    private String title;
    private List<String> ingredients;
    private String instructions;

    public Recipe(String title, List<String> ingredients, String instructions) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }
}
