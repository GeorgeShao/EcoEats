package com.ecoeats;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class Settings extends AppCompatActivity {

    CheckBox Italian, American, Mediterranean, Caribbean, SouthAsian, Asian;
    ArrayList<String> cuisines;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Italian = (CheckBox) findViewById(R.id.italian);
        American = (CheckBox) findViewById(R.id.american);
        Mediterranean = (CheckBox) findViewById(R.id.mediterranean);
        SouthAsian = (CheckBox) findViewById(R.id.indian);
        Asian = (CheckBox) findViewById(R.id.asian);
        Caribbean = (CheckBox) findViewById(R.id.caribbean);
        cuisines = new ArrayList<>();
        if (Italian.isChecked())
            cuisines.add("Italian");
        if (American.isChecked())
            cuisines.add("American");
        if (Mediterranean.isChecked())
            cuisines.add("Mediterranean");
        if (SouthAsian.isChecked())
            cuisines.add("South-Asian");
        if(Asian.isChecked())
            cuisines.add("Asian");
        if(Caribbean.isChecked())
            cuisines.add("Caribbean");
        navigation.getMenu().getItem(3).setChecked(true);

        Spinner spinner;

        spinner = findViewById(R.id.location_spinner);

        final List<String> categories = new ArrayList<String>();

        categories.add("Ontario");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        spinner.setAdapter(dataAdapter);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Settings.this, "Selected : "+ categories.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            switch (item.getItemId()) {
                case R.id.navigation_local_food:
                    intent = new Intent(Settings.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
                case R.id.navigation_schedule:
                    intent = new Intent(Settings.this, Schedule.class);
                    intent.putExtra("cuisines", cuisines);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
                case R.id.navigation_shopping_list:
                    intent = new Intent(Settings.this, ShoppingList.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
                case R.id.navigation_settings:
                    intent = new Intent(Settings.this, Settings.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };
}
