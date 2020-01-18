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
        arrayList.add(new SubjectData("Carrots", "", "https://1etgc323htj92xdrc5372t71zpf-wpengine.netdna-ssl.com/wp-content/uploads/sites/4/2014/05/January-121x172.jpg"));
        arrayList.add(new SubjectData("Potatoes", "", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIqMcWxwgu519AXsVIzPeZqZEVGImS_krusw4uRD70bV0IMkVO&s"));
        arrayList.add(new SubjectData("Onions", "", "https://ichef.bbci.co.uk/news/410/media/images/80896000/jpg/_80896768_red-onion-think624.jpg"));
        arrayList.add(new SubjectData("Cucumbers", "", "https://www.foodsafetynews.com/files/2018/11/long-English-cucumber-550x311.jpg"));
        arrayList.add(new SubjectData("Mushrooms", "", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRtdaWQeAzZuu_C7qFORWQ15LEfFOW_J78h7EZQ7rnT3OJSoEy9&s"));
        arrayList.add(new SubjectData("Cabbage", "", "https://bestoffernearme.com/wp-content/uploads/2019/11/71nFvA-EOeL._SL1500_.jpg"));
        arrayList.add(new SubjectData("Apples", "", "https://i5.walmartimages.com/asr/710231ac-34ab-41a3-9b6c-04d7261ada17_1.a866a242aeccff90ad46e37b7fdf3940.jpeg?odnWidth=450&odnHeight=450&odnBg=ffffff"));
        arrayList.add(new SubjectData("Beets", "", "https://theforkedspoon.com/wp-content/uploads/2017/04/How-to-Cook-Beets-700x1050.jpg"));
        arrayList.add(new SubjectData("Parsnips", "", "https://www.simplyrecipes.com/wp-content/uploads/2009/12/parsnips-horiz-1800.jpg"));
        arrayList.add(new SubjectData("Rutabaga", "", "https://www.farmersalmanac.com/wp-content/uploads/2014/12/turnip-AdobeStock_95185232.jpg"));
        arrayList.add(new SubjectData("Rhubarb", "", "https://theviewfromgreatisland.com/wp-content/uploads/2019/04/rhubarb-stalks-e1554481252586.jpg"));
        arrayList.add(new SubjectData("Strawberries", "", "https://highlandparklbc.files.wordpress.com/2019/06/strawberries.jpg?w=676"));
        arrayList.add(new SubjectData("Lettuce", "", "https://cfig.ca/wp-content/uploads/2018/11/romaine.jpg"));
        arrayList.add(new SubjectData("Peppers", "", "https://i5.walmartimages.ca/images/Enlarge/284/684/6000191284684.jpg"));
        arrayList.add(new SubjectData("Sprouts", "", "https://cdn.drweil.com/wp-content/uploads/2016/12/diet-nutrition_recipes_stir-fried-bean-sprouts_2716x1811_000064913441-600x450.jpg"));
        arrayList.add(new SubjectData("Squash", "", "https://i0.wp.com/cdn-prod.medicalnewstoday.com/content/images/articles/284/284479/butternut-squash.jpg?w=1155&h=1642"));
        arrayList.add(new SubjectData("Sweet Potatoes", "", "https://www.thespruceeats.com/thmb/qKLH4scbuqwGursa5IOC172PyOs=/960x0/filters:no_upscale():max_bytes(150000):strip_icc()/sweetpotatoes_getty2400-56a4975c5f9b58b7d0d7b790.jpg"));
        arrayList.add(new SubjectData("Tomatoes", "", "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2013/5/13/0/FN_tomatoes-thinkstock_s4x3.jpg.rend.hgtvcom.406.305.suffix/1371616351150.jpeg"));

        CustomAdapter customAdapter = new CustomAdapter(this, arrayList);
        list.setAdapter(customAdapter);
    }
}
