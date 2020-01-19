package com.ecoeats;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {

    Recipe recipe;

    ListView ingredientsListView;
    ArrayAdapter<String> ingredientsListAdapter;
    ArrayList<String> ingredientsList;

    ListView instructionsListView;
    ArrayAdapter<String> instructionsListAdapter;
    ArrayList<String> instructionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);
        BottomNavigationView navigation =findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getMenu().getItem(1).setChecked(true);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            recipe = (Recipe) bundle.get("recipe");
        }

        TextView title = findViewById(R.id.recipe);
        title.setText(recipe.getName());

        TextView time = findViewById(R.id.duration);
        time.setText(Integer.toString(recipe.getTime()) + " min");

        ingredientsList =  new ArrayList<>();
        ingredientsListView = findViewById(R.id.ingredients_list);
        ingredientsListAdapter = new ArrayAdapter<>(RecipeActivity.this, android.R.layout.simple_list_item_1, ingredientsList);
        ingredientsListView.setAdapter(ingredientsListAdapter);

        addIngredients(recipe.getIngredients());

        instructionsList =  new ArrayList<>();
        instructionsListView = findViewById(R.id.instructions_list);
        instructionsListAdapter = new ArrayAdapter<>(RecipeActivity.this, android.R.layout.simple_list_item_1, instructionsList);
        instructionsListView.setAdapter(instructionsListAdapter);

        addInstructions(recipe.getInstructions());

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            switch (item.getItemId()) {
                case R.id.navigation_local_food:
                    intent = new Intent(RecipeActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
                case R.id.navigation_schedule:
                    intent = new Intent(RecipeActivity.this, Schedule.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
                case R.id.navigation_shopping_list:
                    intent = new Intent(RecipeActivity.this, ShoppingList.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
                case R.id.navigation_settings:
                    intent = new Intent(RecipeActivity.this, Settings.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    public void addIngredients( ArrayList<String> ingredients) {
        String entry = "";
        for (int i = 0; i < ingredients.size(); i++) {
            entry += "  - " + ingredients.get(i) + "\n";
        }
        ingredientsList.add(entry);
        ingredientsListAdapter.notifyDataSetChanged();
    }

    public void addInstructions( ArrayList<String> instructions) {
        String entry = "";
        for (int i = 0; i < instructions.size(); i++) {
            entry += i+1 + ". " + instructions.get(i) + "\n\n";
        }
        instructionsList.add(entry);
        instructionsListAdapter.notifyDataSetChanged();
    }
    /*
    Example usage:
    addMeal("Meal 1", new ArrayList<String>() {{
                        add("Alpha");
                        add("Beta");
                        add("Cat");
                    }}, new ArrayList<Integer>() {{
                        add(1);
                        add(2);
                        add(3);
                    }});
     */
}