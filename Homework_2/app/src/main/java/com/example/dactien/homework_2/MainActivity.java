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
        lvDish = (ListView) findViewById(R.id.lvDish);
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
                "Apple Spinach Salad", R.drawable.icon_dish1,
                R.drawable.high_dish1, R.drawable.dish1));
        listDish.add(new Dish(
                "Rosemary Chicken Noodle Soup", R.drawable.icon_dish2,
                R.drawable.high_dish2, R.drawable.dish2));
        listDish.add(new Dish(
                "Ingredient Mexican Shredded Chicken", R.drawable.icon_dish3,
                R.drawable.high_dish3, R.drawable.dish3));
        listDish.add(new Dish(
                "Apple Spinach Salad", R.drawable.icon_dish1,
                R.drawable.high_dish1, R.drawable.dish1));
        listDish.add(new Dish(
                "Rosemary Chicken Noodle Soup", R.drawable.icon_dish2,
                R.drawable.high_dish2, R.drawable.dish2));
        listDish.add(new Dish(
                "Ingredient Mexican Shredded Chicken", R.drawable.icon_dish3,
                R.drawable.high_dish3, R.drawable.dish3));
//        listDish.add(new Dish(
//                "The Best Black Bean Chili", R.drawable.icon_dish4,
//                R.drawable.high_dish4, R.drawable.dish4));
//        listDish.add(new Dish(
//                "Peruvian Chicken Soup", R.drawable.icon_dish5,
//                R.drawable.high_dish5, R.drawable.dish5));
//        listDish.add(new Dish(
//                "Cacio e Pepe", R.drawable.icon_dish5,
//                R.drawable.high_dish5, R.drawable.dish5));
//        listDish.add(new Dish(
//                "Instant Pot Barbacoa Beef", R.drawable.icon_dish5,
//                R.drawable.high_dish5, R.drawable.dish5));
//        listDish.add(new Dish(
//                "Quinoa Tortilla Soup", R.drawable.icon_dish5,
//                R.drawable.high_dish5, R.drawable.dish5));
//        listDish.add(new Dish(
//                "Sizzlin’ Spicy Szechuan Stir-Fry", R.drawable.icon_dish5,
//                R.drawable.high_dish5, R.drawable.dish5));
//        listDish.add(new Dish(
//                "Easy Queso Dip", R.drawable.icon_dish5,
//                R.drawable.high_dish5, R.drawable.dish5));
        dishAdapter = new DishAdapter(this, R.layout.custom_item_list, listDish);
        lvDish.setAdapter(dishAdapter);
    }
}
