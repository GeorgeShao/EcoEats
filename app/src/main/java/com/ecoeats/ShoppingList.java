package com.ecoeats;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class ShoppingList extends AppCompatActivity {

    ListView shoppingListView;
    ArrayAdapter<String> listAdapter;
    ArrayList<String> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_list);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getMenu().getItem(2).setChecked(true);
        shoppingListView = (ListView)findViewById(R.id.shopping_list);
        itemsList = new ArrayList<>();
        listAdapter = new ArrayAdapter<>(ShoppingList.this, android.R.layout.simple_list_item_1, itemsList);
        shoppingListView.setAdapter(listAdapter);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_local_food:
                    Intent local_food = new Intent(ShoppingList.this, MainActivity.class);
                    startActivity(local_food);
                    return true;
                case R.id.navigation_schedule:
                    return true;
                case R.id.navigation_shopping_list:
                    Intent intent = new Intent(ShoppingList.this, ShoppingList.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_settings:
                    return true;
            }
            return false;
        }
    };

    public void addMeal(String mealName, ArrayList<String> ingredients, ArrayList<Integer> quantity) {
        String entry = mealName + "\n";
        for (int i = 0; i < ingredients.size(); i++) {
            entry += "  - " + ingredients.get(i) + " x" + quantity.get(i) + "\n";
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
