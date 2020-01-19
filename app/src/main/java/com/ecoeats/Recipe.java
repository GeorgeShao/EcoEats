package com.ecoeats;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<String> Ingredients = new ArrayList<>();
    private ArrayList<String> Instructions = new ArrayList<>();
    private float time;

    public Recipe(){}

    public Recipe(String name, ArrayList<String> Ingredients, ArrayList<String> Instructions, float time){
        this.Ingredients = Ingredients;
        this.Instructions = Instructions;
        this.time = time;
        this.name = name;
    }

    public float getTime() {
        return time;
    }

    public ArrayList<String> getInstructions() {
        return Instructions;
    }

    public ArrayList<String> getIngredients() {
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

