package com.ecoeats;

import android.support.annotation.NonNull;

public class Recipe {
    private String name;
    private String[] Ingredients = new String[30];
    private String[] Instructions = new String[50];
    private float time;

    public Recipe(){}

    public Recipe(String name, String[] Ingredients, String[] Instructions, float time){
        this.Ingredients = Ingredients;
        this.Instructions = Instructions;
        this.time = time;
        this.name = name;
    }

    public float getTime() {
        return time;
    }

    public String[] getInstructions() {
        return Instructions;
    }

    public String[] getIngredients() {
        return Ingredients;
    }

    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name+ " " + this.time;
    }
}

