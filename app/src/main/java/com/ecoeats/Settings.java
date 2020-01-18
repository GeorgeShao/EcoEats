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

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getMenu().getItem(3).setChecked(true);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_local_food:
                    Intent local_food = new Intent(Settings.this, MainActivity.class);
                    startActivity(local_food);
                    return true;
                case R.id.navigation_schedule:
                    Intent schedule = new Intent(Settings.this, Schedule.class);
                    startActivity(schedule);
                    return true;
                case R.id.navigation_shopping_list:
                    Intent shopping_list = new Intent(Settings.this, ShoppingList.class);
                    startActivity(shopping_list);
                    return true;
                case R.id.navigation_settings:
                    Intent settings = new Intent(Settings.this, Settings.class);
                    startActivity(settings);
                    return true;
            }
            return false;
        }
    };
}
