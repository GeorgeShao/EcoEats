package com.ecoeats;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            switch (item.getItemId()) {
                case R.id.navigation_local_food:
                    intent = new Intent(MainActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
                case R.id.navigation_schedule:
                    intent = new Intent(MainActivity.this, Schedule.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
                case R.id.navigation_shopping_list:
                    intent = new Intent(MainActivity.this, ShoppingList.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
                case R.id.navigation_settings:
                    intent = new Intent(MainActivity.this, Settings.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localfood);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final ListView list = findViewById(R.id.localfood_list);
        ArrayList<SubjectData> arrayList = new ArrayList<SubjectData>();
        arrayList.add(new SubjectData("Carrots", "https://www.google.com", "https://1etgc323htj92xdrc5372t71zpf-wpengine.netdna-ssl.com/wp-content/uploads/sites/4/2014/05/January-121x172.jpg"));
        arrayList.add(new SubjectData("Potatoes", "https://www.google.com/", "https://www.producemarketguide.com/sites/default/files/Commodities.tar/Commodities/potatoes_commodity-page.png"));
        arrayList.add(new SubjectData("Onions", "https://www.google.com/", "https://ichef.bbci.co.uk/news/410/media/images/80896000/jpg/_80896768_red-onion-think624.jpg"));
        arrayList.add(new SubjectData("Cucumbers", "https://www.google.com/", "https://www.foodsafetynews.com/files/2018/11/long-English-cucumber-550x311.jpg"));
        arrayList.add(new SubjectData("Mushrooms", "https://www.google.com/", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRtdaWQeAzZuu_C7qFORWQ15LEfFOW_J78h7EZQ7rnT3OJSoEy9&s"));
        arrayList.add(new SubjectData("Cabbage", "https://www.google.com/", "https://bestoffernearme.com/wp-content/uploads/2019/11/71nFvA-EOeL._SL1500_.jpg"));
        arrayList.add(new SubjectData("Apples", "https://www.google.com/", "http://thelunchlady.ca/wp-content/uploads/2015/10/Apples-in-your-diet.jpg"));
        arrayList.add(new SubjectData("Beets", "https://www.google.com/", "https://theforkedspoon.com/wp-content/uploads/2017/04/How-to-Cook-Beets-700x1050.jpg"));
        arrayList.add(new SubjectData("Parsnips", "https://www.google.com/", "https://www.simplyrecipes.com/wp-content/uploads/2009/12/parsnips-horiz-1800.jpg"));
        arrayList.add(new SubjectData("Rutabaga", "https://www.google.com/", "http://www.specialtyproduce.com/sppics/658.png"));
        CustomAdapter customAdapter = new CustomAdapter(this, arrayList);
        list.setAdapter(customAdapter);
    }
}
