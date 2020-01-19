package com.ecoeats;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Schedule extends AppCompatActivity {

    private TextView lunchText;
    private TextView dinnerText;
    private ArrayList<Recipe> recipes =  new ArrayList<>();
    private ArrayList<String> cuisines = new ArrayList<>();
    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getMenu().getItem(1).setChecked(true);
        Bundle bundle = getIntent().getExtras();
        /*if (bundle != null) {
            cuisines = bundle.getStringArrayList("cuisines");
        }*/
        db = FirebaseFirestore.getInstance();

        lunchText =  findViewById(R.id.recipe_name_lunch_textview);
        dinnerText = findViewById(R.id.recipe_name_dinner_textview);


        cuisines.add("American");
        cuisines.add("Italian");
        cuisines.add("Mediterranean");
        cuisines.add("South-Asian");

        getRecipes();
        System.out.println(recipes.size());
        if(recipes.size()>=2){
            displaySchedule(0);
        }
        else{
            Log.e("Schedule activity", "Recipes is too small");
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            switch (item.getItemId()) {
                case R.id.navigation_local_food:
                    intent = new Intent(Schedule.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
                case R.id.navigation_schedule:
                    intent = new Intent(Schedule.this, Schedule.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
                case R.id.navigation_shopping_list:
                    intent = new Intent(Schedule.this, ShoppingList.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
                case R.id.navigation_settings:
                    intent = new Intent(Schedule.this, Settings.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    private void displaySchedule(int day){
        lunchText.setText(recipes.get(day*2).getName());
        dinnerText.setText(recipes.get(day*2+1).getName());
    }

    private void getRecipes(){
        for(String cuisine: cuisines){
            CollectionReference colref = db.collection(cuisine);
            colref.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if(!queryDocumentSnapshots.isEmpty()){
                            List<DocumentSnapshot> dSnaps = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot dSnap:dSnaps){
                                recipes.add(dSnap.toObject(Recipe.class));
                            }
                        }
                        else{
                            Log.e("Schedule activity", "No docs picked up");
                        }
                    }
                }
            );
        }
    }
}
