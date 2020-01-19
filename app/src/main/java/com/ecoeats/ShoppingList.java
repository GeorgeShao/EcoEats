package com.ecoeats;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class ShoppingList extends AppCompatActivity {

    ListView shoppingListView;
    ArrayAdapter<String> listAdapter;
    ArrayList<String> itemsList;
    ArrayList<Recipe> recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_list);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getMenu().getItem(2).setChecked(true);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            recipes = (ArrayList<Recipe>) bundle.get("recipes");
        }
        shoppingListView = findViewById(R.id.shopping_list);
        itemsList = new ArrayList<>();
        listAdapter = new ArrayAdapter<>(ShoppingList.this, android.R.layout.simple_list_item_1, itemsList);
        shoppingListView.setAdapter(listAdapter);

        addMeal(recipes.get(0).getName(), recipes.get(0).getIngredients());
        addMeal(recipes.get(1).getName(), recipes.get(1).getIngredients());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            switch (item.getItemId()) {
                case R.id.navigation_local_food:
                    intent = new Intent(ShoppingList.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
                case R.id.navigation_schedule:
                    intent = new Intent(ShoppingList.this, Schedule.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
                case R.id.navigation_shopping_list:
                    intent = new Intent(ShoppingList.this, ShoppingList.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
                case R.id.navigation_settings:
                    intent = new Intent(ShoppingList.this, Settings.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    public void addMeal(String mealName, ArrayList<String> ingredients) {
        String entry = mealName + "\n";
        for (int i = 0; i < ingredients.size(); i++) {
            entry += "  - " + ingredients.get(i) + "\n";
        }
        itemsList.add(entry);
        listAdapter.notifyDataSetChanged();
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
