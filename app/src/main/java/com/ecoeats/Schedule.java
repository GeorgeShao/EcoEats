package com.ecoeats;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Schedule extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getMenu().getItem(1).setChecked(true);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_local_food:
                    Intent local_food = new Intent(Schedule.this, MainActivity.class);
                    startActivity(local_food);
                    return true;
                case R.id.navigation_schedule:
                    Intent schedule = new Intent(Schedule.this, Schedule.class);
                    startActivity(schedule);
                    return true;
                case R.id.navigation_shopping_list:
                    Intent shopping_list = new Intent(Schedule.this, ShoppingList.class);
                    startActivity(shopping_list);
                    return true;
                case R.id.navigation_settings:
                    Intent settings = new Intent(Schedule.this, Settings.class);
                    startActivity(settings);
                    return true;
            }
            return false;
        }
    };
}
