package com.ecoeats;

public class Recipe {
    private String[] Ingredients = new String[30];
    private String[] Instructions = new String[50];
    private float time;

    public Recipe(){}

    public Recipe(String[] Ingredients, String[] Instructions, float time){
        this.Ingredients = Ingredients;
        this.Instructions = Instructions;
        this.time = time;
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
}

