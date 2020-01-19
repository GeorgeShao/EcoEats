package com.ecoeats;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class Recipe implements java.io.Serializable{
    private String Name;
    private ArrayList<String> Ingredients = new ArrayList<>();
    private ArrayList<String> Instructions = new ArrayList<>();
    private int Time;

    public Recipe(){}

    public Recipe(String name, ArrayList<String> Ingredients, ArrayList<String> Instructions, int time){
        this.Ingredients = Ingredients;
        this.Instructions = Instructions;
        this.Time = time;
        this.Name = name;
    }

    public int getTime() {
        return Time;
    }

    public ArrayList<String> getInstructions() {
        return Instructions;
    }

    public ArrayList<String> getIngredients() {
        return Ingredients;
    }

    public String getName() {
        return Name;
    }

    @NonNull
    @Override
    public String toString() {
        return this.Name+ " " + this.Time;
    }
}

