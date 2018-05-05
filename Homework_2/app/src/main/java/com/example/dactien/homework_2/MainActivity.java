package com.example.dactien.homework_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvDish;
    List<Dish> listDish;
    DishAdapter dishAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        lvDish = findViewById(R.id.lvDish);
        listDish = new ArrayList<>();
        listDish.add(new Dish(
                "Apple Spinach Salad", R.drawable.icon_dish1,
                R.drawable.high_dish1, R.drawable.dish1));
        listDish.add(new Dish(
                "Rosemary Chicken Noodle Soup", R.drawable.icon_dish2,
                R.drawable.high_dish2, R.drawable.dish2));
        listDish.add(new Dish(
                "Ingredient Mexican Shredded Chicken", R.drawable.icon_dish3,
                R.drawable.high_dish3, R.drawable.dish3));
        listDish.add(new Dish(
                "Tamales", R.drawable.icon_dish4,
                R.drawable.high_dish4, R.drawable.dish4));
        listDish.add(new Dish(
                "Guacamole", R.drawable.icon_dish5,
                R.drawable.high_dish5, R.drawable.dish5));
        listDish.add(new Dish(
                "Blueberry Kale Smoothie", R.drawable.icon_dish6,
                R.drawable.high_dish6, R.drawable.dish6));
        listDish.add(new Dish(
                "5 Easy Chicken Marinade Recipes", R.drawable.icon_dish7,
                R.drawable.high_dish7, R.drawable.dish7));
        listDish.add(new Dish(
                "Healthy Peanut Butter Cookies", R.drawable.icon_dish8,
                R.drawable.high_dish8, R.drawable.dish8));
        listDish.add(new Dish(
                "Salsa Verde", R.drawable.icon_dish9,
                R.drawable.high_dish9, R.drawable.dish9));
        listDish.add(new Dish(
                "Naturally-Sweetened Agua Fresca", R.drawable.icon_dish10,
                R.drawable.high_dish10, R.drawable.dish10));
        dishAdapter = new DishAdapter(this, R.layout.custom_item_list, listDish);
        lvDish.setAdapter(dishAdapter);
    }
}
